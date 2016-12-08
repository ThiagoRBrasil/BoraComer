package br.com.alive.boracomer.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alive.boracomer.dao.EventoDAO;
import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Evento;
import br.com.alive.boracomer.entity.Usuario;

@Named
@RequestScoped
public class Home implements Serializable {

	private static final long serialVersionUID = 5899797491047712461L;

	private String user;
	private String pass;

	private String numId;
	private String idUserToInvite;

	private String nomeEvento;
	private String descricaoEvento;
	private String dataEvento;
	private String horaEvento;

	private static Evento evento;
	private static Usuario usuario;
	private static List<Usuario> usuarios;

	private static List<Evento> eventos;

	@PostConstruct
	public void reset() {
		this.user = null;
		this.pass = null;
		this.nomeEvento = null;
		this.descricaoEvento = null;
		this.dataEvento = null;
		this.horaEvento = null;
	}

	@Inject
	private UsuarioDAO usuarioDao;

	@Inject
	private EventoDAO eventoDAO;

	public String loginUsuario() {
		this.usuario = new Usuario();
		List<Usuario> usuarios = usuarioDao.listaUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(user) && usuarios.get(i).getPass().equals(pass)) {
				this.usuario = usuarios.get(i);
				eventos = eventoDAO.findByUserId(usuario.getId_usuario());
				setNumId(String.valueOf(this.usuario.getId_usuario()));

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarios.get(i));
				return "home";
			}
		}
		addMessage("Usuario/Senha incorreto(s)");
		return "index";
	}

	public String cadastrarUsuario() {
		return "cadastrarUsuario?faces-redirect=true";
	}

	public String cadastrarRestaurante() {
		return "cadastrarRestaurante?faces-redirect=true";
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String logout() {
		this.usuario = new Usuario();
		return "index";
	}

	public String novoEvento() {
		return "novoEvento";
	}

	public String cadastrarEvento() {
		evento = new Evento();
		try {
			evento.setNome(nomeEvento);
			evento.setDescricao(descricaoEvento);
			evento.setData(dataEvento);
			evento.setHora(horaEvento);
			evento.setId_usuario(Long.parseLong(String.valueOf(usuario.getId_usuario())));
			eventoDAO.atualizar(evento);
			eventos = eventoDAO.findByUserId(usuario.getId_usuario());
			return "home";
		} catch (Exception e) {
			addMessage("Erro ao cadastrar o evento");
		}
		return "novoEvento";
	}

	public String cancelarNovoEvento() {
		return "home";
	}

	public void convidarAmigo() {
		Usuario usuariosToInvite = usuarioDao.findById(Long.parseLong(idUserToInvite));
		if(usuariosToInvite != null){
			
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public String getIdUserToInvite() {
		return idUserToInvite;
	}

	public void setIdUserToInvite(String idUserToInvite) {
		this.idUserToInvite = idUserToInvite;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}
}
