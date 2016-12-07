package br.com.alive.boracomer.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alive.boracomer.dao.EventoDAO;
import br.com.alive.boracomer.dao.RestauranteDAO;
import br.com.alive.boracomer.entity.Endereco;
import br.com.alive.boracomer.entity.Evento;
import br.com.alive.boracomer.entity.Restaurante;

@Path("/restaurante")
public class RequestRestaurante {

	@Inject
	private RestauranteDAO restauranteDAO;
	
//	@Inject
//	private EventoDAO eventoDAO;

	// Return unique element passing the ID on URL like JSON
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Restaurante getRestauranteJSON(@PathParam("id") Long id) {
		return this.restauranteDAO.findById(id);
	}

	// Save a new Restaurante passing all attributes by URL
	@GET
	@Path("/saveRestaurante/{nome}/{rua}/{numero}/{bairro}/{contato}/{cidade}/{tipo}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response saveRestauranteJSON(
			@PathParam("nome") String nome, @PathParam("rua") String rua,
			@PathParam("numero") String numero, @PathParam("bairro") String bairro,
			@PathParam("contato") String contato, @PathParam("cidade") String cidade, @PathParam("tipo") String tipo) {

		Restaurante restaurante = new Restaurante();
		
		restaurante.setNome(nome);
		restaurante.setBairro(bairro);
		restaurante.setCidade(cidade);
		restaurante.setContato(contato);
		restaurante.setNumero(numero);
		restaurante.setRua(rua);
		restaurante.setTipo(tipo);
		
//		Evento evento = new Evento();
//		evento.setData("data");
//		evento.setDescricao("descricao");
//		evento.setHora("hora");
//		evento.setNome("nome");
//		evento.setEvento_restaurante(restaurante);
//		restaurante.getEventos().add(evento);
//		this.eventoDAO.atualizar(evento);
		this.restauranteDAO.atualizar(restaurante);
		return Response.status(200).entity("Salvo com sucesso!").build();
	}

	// Delete the unique Restaurante by ID
	@GET
	@Path("/delRestaurante/{id}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response deleteRestauranteJSON(
			@PathParam("id") Long id) {
		this.restauranteDAO.excluir(this.restauranteDAO.findById(id));
		return Response.status(200).entity("Feito").build();
	}

	// Retorn all Restaurante like JSON
	@GET
	@Path("/listRestaurantes")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Restaurante> getListaJogadoresJSON() {
		return	this.restauranteDAO.listaRestaurantes();
	}

}
