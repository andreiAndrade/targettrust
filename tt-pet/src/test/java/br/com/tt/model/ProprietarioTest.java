package br.com.tt.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.tt.exception.PetException;

public class ProprietarioTest {

	private Proprietario proprietario;

	@Before
	public void init() {
		proprietario = new Proprietario();
	}

	@Test
	public void addTelefoneTest() {
		proprietario.addTelefone(null);
		Telefone telefone = new Telefone();
		proprietario.addTelefone(telefone);

		assertFalse(proprietario.getTelefones().isEmpty());
		assertNotNull(telefone.getProprietario());
	}

	@Test(expected = PetException.class)
	public void setCpfInvalidoTest() throws PetException {
		proprietario.setCpf("000000000");
	}
	@Test
	public void setCpfValidoTest() throws PetException {
		proprietario.setCpf("03201846090");
	}

}
