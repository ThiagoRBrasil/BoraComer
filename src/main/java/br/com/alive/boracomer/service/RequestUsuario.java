package br.com.alive.boracomer.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
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

	@Inject
	private EventoDAO eventoDAO;

	@POST
	@Path("/getAllEventos")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Evento> getAllEventosPost(@FormParam("nome") String nome, @FormParam("pass") String pass) {
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = usuarioDAO.listaUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(nome) && usuarios.get(i).getPass().equals(pass)) {
				usuario = usuarios.get(i);
				return eventoDAO.findByUserId(usuario.getId_usuario());
			}
		}
		List<Evento> listaEventos = new ArrayList<Evento>();
		listaEventos.add(new Evento());
		return listaEventos;
	}

	@GET
	@Path("/getAllEventos/{nome}/{pass}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Evento> getAllEventosGet(@PathParam("nome") String nome, @PathParam("pass") String pass) {
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = usuarioDAO.listaUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(nome) && usuarios.get(i).getPass().equals(pass)) {
				usuario = usuarios.get(i);
				return eventoDAO.findByUserId(usuario.getId_usuario());
			}
		}
		List<Evento> listaEventos = new ArrayList<Evento>();
		listaEventos.add(new Evento());
		return listaEventos;
	}

	@GET
	@Path("/addUsuario/{nome}/{pass}/{idade}/{email}")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public String getAllEventosGet(@PathParam("nome") String nome, @PathParam("pass") String pass,
			@PathParam("idade") String idade, @PathParam("email") String email) {

		try {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setPass(pass);
			usuario.setIdade(Integer.parseInt(idade));
			usuario.setEmail(email);

			usuarioDAO.atualizar(usuario);
			return "Cadastrado com Sucesso";
		} catch (Exception e) {
			return "Houve um erro no cadastro";
		}
		
	}

}
