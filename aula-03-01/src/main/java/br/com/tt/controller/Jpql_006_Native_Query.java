package br.com.tt.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Jpql_006_Native_Query {

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
		String sql = "SELECT * FROM Cliente";
		Query query = em.createNativeQuery(sql, Cliente.class);
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		clientes.forEach(System.out::println);
	}

	private static void listaClientePorNome() {
		String sql = "SELECT * FROM cliente WHERE nome LIKE :nome";
		Query query = em.createNativeQuery(sql, Cliente.class);
		query.setParameter("nome", "%Mar%");
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		clientes.forEach(System.out::println);
	}

	private static void listaClientePorNomeEDataNasc() {
		String sql = "SELECT * FROM cliente WHERE nome LIKE :nome AND dataNasc < :dataNasc";
		Query query = em.createNativeQuery(sql, Cliente.class);
		query.setParameter("nome", "%Mari%");
		query.setParameter("dataNasc", Calendar.getInstance());
		List clientes = query.getResultList();
		clientes.forEach(System.out::println);
	}
}
