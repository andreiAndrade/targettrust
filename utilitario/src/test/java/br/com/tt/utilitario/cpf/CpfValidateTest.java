package br.com.tt.utilitario.cpf;

import static org.junit.Assert.*;

import org.junit.Test;

public class CpfValidateTest {

	@Test
	public void testValidate() {
		assertTrue(CpfValidate.validate("03201846090"));
		assertFalse(CpfValidate.validate("03201846190"));
	}

}
