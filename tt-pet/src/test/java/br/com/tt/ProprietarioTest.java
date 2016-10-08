package br.com.tt;

import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

public class ProprietarioTest {

	@Test
	public void testAddTelefone() {
		Proprietario proprietario = new Proprietario();
		proprietario.addTelefone(null);
		Telefone telefone = new Telefone();
		proprietario.addTelefone(telefone);
		
		assertFalse(proprietario.getTelefones().isEmpty());
		assertNotNull(telefone.getProprietario());
	}

}
