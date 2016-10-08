package br.com.tt.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testAddEndereco() {
		Cliente cliente = new Cliente();
		cliente.addEndereco(new Endereco());
		cliente.addEndereco(null);
	}

}
