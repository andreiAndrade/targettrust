package br.com.tt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;

public class ClienteDAO {

	//Emptiti
	private EntityManager em;
	private EntityTransaction trans;
	
	public ClienteDAO() {
		//bu_jpa
		this.em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		this.trans = em.getTransaction();
	}
	
	//Void, pois n precisa retornar o objeto com o valor, ele setta por referencia
	public void salvar(Cliente cliente) {
		this.trans.begin();
		this.em.persist(cliente);
		this.trans.commit();
	}
	
	//detach -> detãtiti
	
}
