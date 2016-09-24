package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.MateriaDidaticoPkIdClass;
import br.com.tt.model.MaterialDidatico;

public class Sistema {
	public static void main(String[] args) {
		System.out.println("Iniciando JPA");
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(criaMaterialDidatico());
		tx.commit();
		em.close();
		
		System.exit(0);
	}

	private static MaterialDidatico criaMaterialDidatico() {
		MaterialDidatico md = new MaterialDidatico();
		MateriaDidaticoPkIdClass id = new MateriaDidaticoPkIdClass("JPA", 1);
		md.setId(id);
		md.setDescricao("O melhor curso");
		md.setProfessor("Paulo Heck");
		
		return md;
	}
}
