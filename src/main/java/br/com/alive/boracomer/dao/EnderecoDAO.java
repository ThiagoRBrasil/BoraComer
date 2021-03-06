/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alive.boracomer.dao;

import br.com.alive.boracomer.entity.Endereco;
import br.com.alive.boracomer.entity.Restaurante;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("enderecoDao")
@Dependent
public class EnderecoDAO {
	
	@PersistenceContext(unitName = "boracomer")
	private EntityManager entityManager;

	@Transactional
	public void excluir(Endereco endereco) {
		this.entityManager.remove(this.entityManager.contains(endereco) ? endereco : this.entityManager.merge(endereco));
	}

	public List<Endereco> listaEnderecos() {
		TypedQuery<Endereco> query = entityManager.createQuery("select u from Endereco u", Endereco.class);
		return query.getResultList();
	}

	@Transactional
	public void salvar(Endereco endereco) {
		this.entityManager.merge(endereco);
	}

	@Transactional
	public void atualizar(Endereco endereco) {
		this.entityManager.merge(endereco);
	}

	@Transactional
	public Endereco findById(Long id) {
		String queryStr = "select u from Endereco u where u.id = :id";
		TypedQuery<Endereco> query = this.entityManager.createQuery(queryStr, Endereco.class);
		query.setParameter("id", id);
		List<Endereco> enderecos = query.getResultList();
		return enderecos.isEmpty() ? null : enderecos.get(0);
	}
	
}
