package br.com.tt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Jpql_008_Criteria {

	static EntityManager em;

	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();

		consultar("Marcia", "64851", "a");

		System.exit(0);
	}

	private static void consultar(String nome, String cpf, String cidade) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
		Root<Cliente> from = query.from(Cliente.class);
		Path<String> cidadePath = from.join("enderecos").<String>get("cidade");
		
		List<Predicate> predicates = new ArrayList<>();
		if (nome != null) {
			Predicate like = cb.like(from.<String>get("nome"), "%" + nome + "%");
			predicates.add(like);
		}
		if (cpf != null) {
			Predicate like = cb.equal(from.<String>get("cpf"), cpf);
			predicates.add(like);
		}
		if (cidade != null) {
			Predicate like = cb.like(cidadePath, "%"+ cidade +"%");
			predicates.add(like);
		}

		query.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Cliente> queryResult = em.createQuery(query);
		List<Cliente> clientes = queryResult.getResultList();

		clientes.forEach(System.out::println);
	}
}