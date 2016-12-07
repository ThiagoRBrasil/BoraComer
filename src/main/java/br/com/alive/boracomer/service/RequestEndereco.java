package br.com.alive.boracomer.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alive.boracomer.dao.EnderecoDAO;
import br.com.alive.boracomer.dao.RestauranteDAO;
import br.com.alive.boracomer.entity.Endereco;
import br.com.alive.boracomer.entity.Restaurante;

@Path("/endereco")
public class RequestEndereco {

	@Inject
	private EnderecoDAO enderecoDAO;

	// Return unique element passing the ID on URL like JSON
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Endereco getEndereco(@PathParam("id") Long id) {
		return this.enderecoDAO.findById(id);
	}

	// Save a new Endereco passing all attributes by URL
	@GET
	@Path("/addEndereco/{nome}/{rua}/{numero}/{bairro}/{contato}/{cidade}/{tipo}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response addEndereco(
			@PathParam("nome") String nome, @PathParam("rua") String rua,
			@PathParam("numero") String numero, @PathParam("bairro") String bairro,
			@PathParam("contato") String contato, @PathParam("cidade") String cidade, @PathParam("tipo") String tipo) {

//		Endereco endereco = new Endereco();
//		endereco.setBairro(bairro);
//		endereco.setCidade(cidade);
//		endereco.setContato(contato);
//		endereco.setNumero(numero);
//		endereco.setRua(rua);
//
//		Restaurante restaurante = new Restaurante();
//		restaurante.setNome(nome);
//		restaurante.setEndereco(endereco);
//		restaurante.setTipo(tipo);
//		System.out.println("Pre salvamento <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		this.restauranteDAO.atualizar(restaurante);
		return Response.status(200).entity("Salvo com sucesso!").build();
	}

	// Delete the unique Restaurante by ID
	@GET
	@Path("/delEndereco/{id}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response deleteRestauranteJSON(
			@PathParam("id") Long id) {
//		this.restauranteDAO.excluir(this.enderecoDAO.findById(id));
		return Response.status(200).entity("Feito").build();
	}

	// Retorn all Restaurante like JSON
	@GET
	@Path("/listEnderecos")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Endereco> getAllEnderecos() {
		return	this.enderecoDAO.listaEnderecos();
	}

}
