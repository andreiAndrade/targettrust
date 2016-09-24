package br.com.tt.controller;

import br.com.tt.dao.ClienteDAO;
import br.com.tt.model.Cliente;
import br.com.tt.model.Telefone;

public class Sistema {
	public static void main(String[] args) {
		new ClienteDAO("pu_jpa").salvar(criaCliente("mandela"));
		
		System.exit(0);
	}

	private static Cliente criaCliente(String nome) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf("12312345678");
		cliente.addTelefone(new Telefone("051", "985009958"));
		cliente.addTelefone(new Telefone("051", "985009959"));
		cliente.addTelefone(new Telefone("051", "985009957"));

		return cliente;
	}
}
