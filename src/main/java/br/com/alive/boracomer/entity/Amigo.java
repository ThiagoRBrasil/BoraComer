package br.com.alive.boracomer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "amigo", schema = "boracomer")
public class Amigo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_amigo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private boolean convite;

    public Long getId_amigo() {
        return id_amigo;
    }

    public void setId_amigo(Long id_amigo) {
        this.id_amigo = id_amigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isConvite() {
        return convite;
    }

    public void setConvite(boolean convite) {
        this.convite = convite;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_amigo == null) ? 0 : id_amigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amigo other = (Amigo) obj;
		if (id_amigo == null) {
			if (other.id_amigo != null)
				return false;
		} else if (!id_amigo.equals(other.id_amigo))
			return false;
		return true;
	}

}
