package br.com.tt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;

public class ClienteDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public ClienteDAO(String pu) {
		this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
		this.tx = em.getTransaction();
	}
	
	public void salvar(Cliente cliente) {
		tx.begin();
		em.persist(cliente);
		tx.commit();
		em.clear();
		em.close();
	}

}
