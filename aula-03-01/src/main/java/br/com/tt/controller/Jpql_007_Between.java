package br.com.tt.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;

public class Jpql_007_Between {

	static EntityManager em;

	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		
		Calendar dataIni = Calendar.getInstance();
		dataIni.set(1900, Calendar.JANUARY, 01);
		Calendar dataFim = Calendar.getInstance();
		dataIni.set(2020, Calendar.JANUARY, 01);
		String sql = "SELECT c FROM Cliente c WHERE c.dataNasc BETWEEN :dataInicio AND :dataFim";
		TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);
		query.setParameter("dataInicio", dataIni);
		query.setParameter("dataFim", dataFim);
		
		List<Cliente> clientes = query.getResultList();
		
		clientes.forEach(System.out::println);

		System.exit(0);
	}
}
