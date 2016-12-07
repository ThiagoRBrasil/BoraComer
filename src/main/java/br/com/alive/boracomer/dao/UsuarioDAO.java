package br.com.alive.boracomer.dao;

import br.com.alive.boracomer.entity.Usuario;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jboss.resteasy.annotations.ResponseObject;

import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class UsuarioDAO {

	@PersistenceContext(unitName = "boracomer")
	private EntityManager entityManager;

	@Transactional
	public void excluir(Usuario usuario) {
		this.entityManager.remove(this.entityManager.contains(usuario) ? usuario : this.entityManager.merge(usuario));
	}

	public List<Usuario> listaUsuarios() {
		TypedQuery<Usuario> query = entityManager.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}

	@Transactional
	public void salvar(Usuario usuario) {
		this.entityManager.merge(usuario);
	}

	@Transactional
	public void atualizar(Usuario usuario) {
		this.entityManager.merge(usuario);
	}

}
