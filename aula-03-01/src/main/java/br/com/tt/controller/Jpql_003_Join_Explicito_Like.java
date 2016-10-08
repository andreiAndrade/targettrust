package br.com.tt.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;

public class Jpql_003_Join_Explicito_Like {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		String jpql = "SELECT DISTINCT c FROM Cliente c JOIN FETCH c.enderecos e WHERE e.cidade LIKE :cidade";
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		query.setParameter("cidade", "Porto Alegre");
		List<Cliente> clientes = query.getResultList();
		
		clientes.forEach(c -> {
			System.out.println(c.getNome());
			c.getEnderecos().forEach(e -> {
				System.out.println("\t ---" + e.getCidade());
			});
		});
		
		System.exit(0);
	}
}
