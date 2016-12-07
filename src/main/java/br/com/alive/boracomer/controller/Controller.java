/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alive.boracomer.controller;

import br.com.alive.boracomer.entity.Usuario;
import br.com.alive.boracomer.entity.Evento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class Controller implements Serializable {

	private static final long serialVersionUID = 6866871548703625676L;
	protected Usuario usuario;
	private String user;
    private String pass;

    @PostConstruct
    public void reset() {
    	this.usuario = new Usuario();
        this.user = null;
        this.pass = null;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getId(){
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Usuario user = (Usuario) sessionMap.get("usuario");
    	return String.valueOf(user.getId_usuario());
    }
    
//    public List<Evento> getEventos(){
//    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> sessionMap = externalContext.getSessionMap();
//        Usuario user = (Usuario) sessionMap.get("usuario");
//    	return user.getEventos();
//    }
   
}
