package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.Animal;
import br.com.tt.model.Especie;

public class Sistema {
	public static void main(String[] args) {
		System.out.println("Iniciando JPA");
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(new Animal("Totó", Especie.CACHORRO));
		em.persist(new Animal("Nemo", Especie.PEIXE));
		em.flush();
		tx.commit();
		em.clear();
		em.close();
		System.out.println("Animais Salvo com Sucesso");
		System.exit(0);
	}
}
