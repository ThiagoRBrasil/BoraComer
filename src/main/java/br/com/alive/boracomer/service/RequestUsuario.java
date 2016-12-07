package br.com.alive.boracomer.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alive.boracomer.dao.EventoDAO;
import br.com.alive.boracomer.dao.RestauranteDAO;
import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Endereco;
import br.com.alive.boracomer.entity.Evento;
import br.com.alive.boracomer.entity.Restaurante;
import br.com.alive.boracomer.entity.Usuario;

@Path("/usuario")
public class RequestUsuario {

	@Inject
	private UsuarioDAO usuarioDAO;

	// @Inject
	// private EventoDAO eventoDAO;

	// Return unique element passing the ID on URL like JSON
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Restaurante getRestauranteJSON(@PathParam("id") Long id) {
		return this.usuarioDAO.findById(id);
	}

	// Save a new Restaurante passing all attributes by URL
	@GET
	@Path("/saveUsuario/{nome}/{pass}/{idade}/{email}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response saveRestauranteJSON(@PathParam("nome") String nome, @PathParam("pass") String pass,
			@PathParam("idade") String idade, @PathParam("email") String email) {

		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setPass(pass);
		usuario.setIdade(Integer.parseInt(idade));
		usuario.setEmail(email);

		this.usuarioDAO.atualizar(usuario);
		return Response.status(200).entity("Salvo com sucesso!").build();
	}

	// Delete the unique Restaurante by ID
	@POST
	@Path("/getAllEventos")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response deleteRestauranteJSON(@FormParam("nome") String nome, @FormParam("pass") String pass) {
		this.restauranteDAO.excluir(this.restauranteDAO.findById(id));
		return Response.status(200).entity("Feito").build();
	}

	// Retorn all Restaurante like JSON
	@GET
	@Path("/getAllEventos")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Restaurante> getListaJogadoresJSON() {
		return this.usuarioDAO.listaUsuarios();
	}

}
