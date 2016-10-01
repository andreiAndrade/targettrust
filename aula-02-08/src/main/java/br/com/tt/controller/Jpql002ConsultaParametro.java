package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import static spark.Spark.*;

import br.com.tt.model.Cliente;

public class Jpql002ConsultaParametro {
	private static String result;
	public static void main(String[] args) {
		EntityManager em = Persistence
				.createEntityManagerFactory("pu_jpa")
				.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("andrei");
		cliente.setCpf("545645465");
		Cliente cliente2 = new Cliente();
		cliente2.setNome("andrei");
		cliente2.setCpf("545645465");
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.merge(cliente2);
		em.getTransaction().commit();
		
		String qlString = "SELECT c FROM Cliente c WHERE c.nome = :nome";
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		query.setParameter("nome", "andrei");
		
		List<Cliente> clientes = query.getResultList();
		clientes.forEach(System.out::println);
	}
}
