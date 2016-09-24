package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Curso;

public class Sistema {
public static void main(String[] args) {
	System.out.println("Iniciando JPA");
	EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	em.getTransaction().begin();
	em.persist(criaCurso());
	em.getTransaction().commit();
	System.exit(0);
	
}

private static Curso criaCurso() {
	Curso curso = new Curso();
	curso.setCodigo("124545");
	curso.setTurno("Sábado");
	curso.setDescricao("Curso de JPA");
	curso.setProfessor("Paulo");
	curso.setHoras(32);
	
	return curso;
}
}
