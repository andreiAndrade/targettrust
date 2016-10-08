package br.com.tt.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Jpql_005_Named_Query {

	static EntityManager em;
	
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		listaCliente();
		System.out.println("-----------------");
		listaClientePorNome();
		System.out.println("-----------------");
		listaClientePorNomeEDataNasc();
		System.exit(0);
	}

	private static void listaCliente() {
		em.createNamedQuery(Cliente.QUERY_LISTA, Cliente.class)
		.getResultList()
		.forEach(System.out::println);
	}
	private static void listaClientePorNome() {
		TypedQuery<Cliente> query = em.createNamedQuery(Cliente.QUERY_LISTA_BY_NOME, Cliente.class);
		query.setParameter("nome", "%M%");
		query
		.getResultList()
		.forEach(System.out::println);
	}
	private static void listaClientePorNomeEDataNasc() {
		TypedQuery<Cliente> query = em.createNamedQuery(Cliente.QUERY_LISTA_BY_NOME_AND_DATANASC, Cliente.class);
		query.setParameter("nome", "%Mar%");
		query.setParameter("dataNasc", Calendar.getInstance());
		query
		.getResultList()
		.forEach(System.out::println);
	}
}
