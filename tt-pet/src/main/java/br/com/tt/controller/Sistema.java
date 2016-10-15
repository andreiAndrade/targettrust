package br.com.tt.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Pet;

public class Sistema {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(new Pet());
			em.getTransaction().commit();
			
			Pet pet = em.find(Pet.class, 1L);
			Pet pet2 = em.find(Pet.class, 1L);
			
			em.getTransaction().begin();
			pet.setNome("toto");
			pet.setDataNasc(LocalDate.now().minusDays(60));
			em.persist(pet);
			em.getTransaction().commit();
			
			em.getTransaction().begin();
			pet2.setNome("Rex");
			em.persist(pet2);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.exit(0);
		}
	}
}
