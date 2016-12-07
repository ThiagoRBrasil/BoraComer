package br.com.alive.boracomer.dao;

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
public class RestauranteDAO {

	@PersistenceContext(unitName = "boracomer")
	private EntityManager entityManager;

	@Transactional
	public void excluir(Restaurante restaurante) {
		this.entityManager.remove(this.entityManager.contains(restaurante) ? restaurante : this.entityManager.merge(restaurante));
	}

	public List<Restaurante> listaRestaurantes() {
		TypedQuery<Restaurante> query = entityManager.createQuery("select u from Restaurante u", Restaurante.class);
		return query.getResultList();
	}

	@Transactional
	public void salvar(Restaurante restaurante) {
		this.entityManager.merge(restaurante);
	}

	@Transactional
	public void atualizar(Restaurante restaurante) {
		this.entityManager.merge(restaurante);
	}
	
	@Transactional
	public Restaurante findById(Long id) {
		String queryStr = "select u from Restaurante u where u.id = :id";
		TypedQuery<Restaurante> query = this.entityManager.createQuery(queryStr, Restaurante.class);
		query.setParameter("id", id);
		List<Restaurante> restaurantes = query.getResultList();
		return restaurantes.isEmpty() ? null : restaurantes.get(0);
	}

}
