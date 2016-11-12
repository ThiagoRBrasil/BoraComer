package br.com.alive.boracomer.controller;

import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ControllerLogin extends Controller implements Serializable {

    private String user;
    private String pass;
    
    @Inject
   	private UsuarioDAO usuarioDao;

    @PostConstruct
    public void reset() {
        this.user = null;
        this.pass = null;
    }

    public String loginUsuario() {
        if (this.user.equals("admin") && this.pass.equals(pass)) {
            super.usuario = new Usuario();
            
            List<Usuario> usuarios = usuarioDao.listaUsuarios();
            boolean log = false;
            int cont = 0;
            for(int i = 0; i < usuarios.size();i++){
            	if(usuarios.get(i).getNome().equals(user)
            			&& usuarios.get(i).getPass().equals(pass)){
            		super.usuario = usuarios.get(i);
            	}
            }
            
            return "home?faces-redirect=true";
        }
        addMessage("Usuario/Senha incorreto(s)");
        return null;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
