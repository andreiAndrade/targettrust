package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Pessoal;

public class Sistema {
	public static void main(String[] args) {

		System.out.println("\n\t\tIniciando o Sistema");

		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		em.getTransaction().begin();
		em.persist(new Pessoal(1L, "Maria"));
		em.persist(new Pessoal(2L, "Pedro"));
		em.persist(new Pessoal(3L, "Tonio", "A", "A", "R"));
		em.persist(new Pessoal(4L, "Jamal", "B", "B", "R"));
		em.persist(new Pessoal(5L, "Miseravi", "C", "C", "R"));
		em.getTransaction().commit();
		em.clear();
		em.close();
		System.out.println("Fim do Sistema");
		System.exit(0);

	}
}
