package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Aluno;
import br.com.tt.model.Cliente;
import br.com.tt.model.Pessoa;
import br.com.tt.model.Professor;

public class Sistema {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();

		Cliente cliente = new Cliente();
		cliente.setNome("GetNet");
		cliente.setCnpj("465456465");

		Professor professor = new Professor();
		professor.setNome("Camila Costa");
		professor.setSalario(15000D);
		
		Aluno aluno = new Aluno();
		aluno.setNome("Lucas Pratto");
		aluno.setCurso("jpa");
		
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.merge(professor);
			em.merge(aluno);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.exit(0);

	}
}
