package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;

public class Sistema {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Geraldo");
		cliente.setCpf("13456789");
		
		System.out.println("EM contains cliente = " + em.contains(cliente));
		em.getTransaction().begin();
		System.out.println("EM contains cliente = " + em.contains(cliente));
		em.merge(cliente);
		System.out.println("Realizando Commit");
		em.getTransaction().commit();
		System.out.println("EM contains cliente = " + em.contains(cliente));
		System.exit(0);
	}
}
