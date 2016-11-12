/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alive.boracomer.controller;

import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroUsuario implements Serializable {

    private Usuario usuario;

    private String nome;
    private String pass;
    private String idade;
    private String email;
    
    @Inject
	private UsuarioDAO usuarioDao;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public String cadastrarUsuario() {

//        usuario.setId_usuario(Long.MIN_VALUE);
        usuario.setNome(nome);
        usuario.setPass(pass);
        usuario.setIdade(Integer.parseInt(idade));
        usuario.setEmail(email);
        
        usuarioDao.atualizar(usuario);

        return "index?faces-redirect=true";
    }

    public String cancelarCadastro() {
        return "index?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
