package br.com.tt.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;

public class Jpql_002_Join_Explicito {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		String jpql = "SELECT DISTINCT c FROM Cliente c JOIN FETCH c.enderecos ";
		List<Cliente> clientes = em.createQuery(jpql, Cliente.class).getResultList();
		
		clientes.forEach(c -> {
			System.out.println(c.getNome());
			c.getEnderecos().forEach(e -> {
				System.out.println("\t ---" + e.getCidade());
			});
		});
		
		System.exit(0);
	}
}
