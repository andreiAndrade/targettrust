package br.com.tt.controller;

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;

public class Sistema {
	static EntityManager em;
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();

		salvarCliente("Maria", "4545454", data(30, Calendar.JULY, 1980), "Porto Alegre", "Canoas");
		salvarCliente("Pedro", "454654", data(30, 6, 2005), "blumenau");
		salvarCliente("Carla", "7987441", data(30, 6, 2000), "ccac", "sdafas");
		salvarCliente("Marcia", "64851", data(30, 6, 2000), "ajh", "bvdczx", "cvmdsv");
		salvarCliente("Felipe", "1234165", data(30, 6, 2000), "d");
		salvarCliente("Lucas", "165410", data(30, 6, 2000), "afdfd", "fdsf", "sdf", "fsd");
		salvarCliente("José", "5264650", data(30, 6, 2000), "afg");
	}

	private static void salvarCliente(String nome, String cpf, Calendar dataNasc, String... cidades) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNasc(dataNasc);
		Arrays.asList(cidades).forEach(cidade -> cliente.addCidade(cidade));
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();

	}

	private static Calendar data(int dia, int mes, int ano) {
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.set(ano, mes, dia);
		return dataNasc;
	}
}
