package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Sistema {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		em.getTransaction().begin();
		em.persist(criaCliente());
		em.getTransaction().commit();
		System.exit(0);
	}

	private static Cliente criaCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Eu mesmo");
		cliente.setCpf("03201846090");
		Endereco endereco = new Endereco();
		endereco.setCidade("Porto Alegre");
		endereco.setRua("Av. Brasil");
		cliente.setEndereco(endereco);
		return cliente;
	}
}
