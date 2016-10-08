package br.com.tt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.tt.model.Cliente;

public class Jpql_009_Criteria {

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
		Join<Object, Object> joinEndereco = from.join("enderecos");
		
		List<Predicate> predicates = new ArrayList<>();
		whereLike(nome, cb, from, predicates);
		whereEqualsCpf(cpf, cb, from, predicates);
		whereLike(cidade, cb, from, predicates);

		query.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Cliente> queryResult = em.createQuery(query);
		List<Cliente> clientes = queryResult.getResultList();

		clientes.forEach(System.out::println);
	}

	private static void whereEqualsCpf(String cpf, CriteriaBuilder cb, Root<Cliente> from, List<Predicate> predicates) {
		if (cpf != null) {
			Predicate like = cb.equal(from.<String>get("cpf"), cpf);
			predicates.add(like);
		}
	}

	private static void whereLike(String nome, CriteriaBuilder cb, Root<Cliente> from, List<Predicate> predicates) {
		if (nome != null) {
			Predicate like = cb.like(from.<String>get("nome"), "%" + nome + "%");
			predicates.add(like);
		}
	}
}