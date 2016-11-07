package br.com.alive.boracomer.controller;

import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Amigo;
import br.com.alive.boracomer.entity.Evento;
import br.com.alive.boracomer.entity.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ControllerHome extends Controller implements Serializable{

	private List<Usuario> listaUsuarios;
    
    @Inject
	private UsuarioDAO usuarioDao;
    
    //POVOAR ESSSAS DUAS LISTAS COM OBJETOS VINDOS DO BANCO
        
    public String logout(){
        return "index?faces-redirect=true";
    }
    
    public String novoEvento(){
        return "novoEvento?faces-redirect=true";
    }
    
    public void convidarAmigo(){
        
    }

    public List<Usuario> getUsuarios() {
        return usuarioDao.listaUsuarios();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.listaUsuarios = usuarios;
    }
}
