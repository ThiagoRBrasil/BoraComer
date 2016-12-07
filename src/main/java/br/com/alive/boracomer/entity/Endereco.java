package br.com.alive.boracomer.entity;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "endereco", schema = "boracomer")
@SequenceGenerator(name = "EnderecoSequence", sequenceName = "SQ_ID_ENDERECO", allocationSize = 1)
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5422967444616865438L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EnderecoSequence")
    private Long id_endereco;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "contato", nullable = true)
    private String contato;

    @Column(name = "cidade", nullable = true)
    private String cidade;

//    @OneToOne(mappedBy="endereco")
//    private Restaurante restaurante;
    //
    //GETTERS AND SETTERS\\
    //

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
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

//    public Restaurante getRestaurante() {
//        return restaurante;
//    }
//
//    public void setRestaurante(Restaurante restaurante) {
//        this.restaurante = restaurante;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id_endereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id_endereco, other.id_endereco)) {
            return false;
        }
        return true;
    }

}
