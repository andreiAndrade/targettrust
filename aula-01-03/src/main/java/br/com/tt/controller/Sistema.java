package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Pet;

public class Sistema {
	public static void main(String[] args) {
		System.out.println("Iniciando JPA");

		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		em.getTransaction().begin();
		em.persist(new Pet());
		em.persist(new Pet("Britney"));
		em.persist(new Pet("Louro", 21));
		em.persist(new Pet());
		em.getTransaction().commit();
		em.clear();
		em.close();
		System.out.println("\nFinalizado com sucesso");
		System.exit(0);
	}
}
