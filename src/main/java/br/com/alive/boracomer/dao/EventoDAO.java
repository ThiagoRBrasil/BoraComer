package br.com.alive.boracomer.dao;

import br.com.alive.boracomer.entity.Evento;
import br.com.alive.boracomer.entity.Restaurante;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class EventoDAO {

	@PersistenceContext(unitName = "boracomer")
	private EntityManager entityManager;

	@Transactional
	public void excluir(Evento evento) {
		this.entityManager.remove(this.entityManager.contains(evento) ? evento : this.entityManager.merge(evento));
	}

	public List<Evento> listaUsuarios() {
		TypedQuery<Evento> query = entityManager.createQuery("select u from Evento u", Evento.class);
		return query.getResultList();
	}

	@Transactional
	public void salvar(Evento evento) {
		this.entityManager.merge(evento);
	}

	@Transactional
	public void atualizar(Evento evento) {
		this.entityManager.merge(evento);
	}
	
	@Transactional
	public List<Evento> findByUserId(Long idUsuario) {
		String queryStr = "select u from Evento u where u.id_usuario = :idUsuario";
		TypedQuery<Evento> query = this.entityManager.createQuery(queryStr, Evento.class);
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}

}
