package br.com.tt.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Jpql_004_Join_Implicito_Like {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		String jpql = "SELECT DISTINCT e FROM Endereco e WHERE e.cliente.nome LIKE :nome";
		TypedQuery<Endereco> query = em.createQuery(jpql, Endereco.class);
		query.setParameter("nome", "Maria");
		List<Endereco> enderecos = query.getResultList();

		enderecos.forEach(e -> {
			System.out.println(e.getCliente().getNome());
			System.out.println("\t ---" + e.getCidade());
		});

		System.exit(0);
	}
}
