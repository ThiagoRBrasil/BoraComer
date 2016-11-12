package br.com.alive.boracomer.controller;

import br.com.alive.boracomer.dao.EnderecoDAO;
import br.com.alive.boracomer.dao.RestauranteDAO;
import br.com.alive.boracomer.dao.UsuarioDAO;
import br.com.alive.boracomer.entity.Endereco;
import br.com.alive.boracomer.entity.Restaurante;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroRestaurante implements Serializable {

    private Restaurante restaurante;
    private String nome;
    private String rua;
    private String numero;
    private String bairro;
    private String contato;
    private String cidade;
    private String tipo;
    
    @Inject
	private RestauranteDAO restauranteDao;

    @PostConstruct
    public void init() {
        this.restaurante = new Restaurante();
    }

    public String cadastrarRestaurante() {
        restaurante.setNome(nome);
        restaurante.setTipo(tipo);

        Endereco endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setContato(contato);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        restaurante.setNome(nome);
        restaurante.setEndereco(endereco);
        restauranteDao.atualizar(restaurante);

        return "index?faces-redirect=true";
    }

    public String cancelarCadRestaurante() {
        return "index?faces-redirect=true";
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
