package br.com.tt.controller;

import br.com.tt.dao.PetDAO;
import br.com.tt.model.Pet;

public class PetController {
	public static void main(String[] args) {
		Pet pet = new Pet();
		pet.setNome("toto");
		
		PetDAO petDAO = new PetDAO();
		petDAO.salvar(pet);
		System.out.println(petDAO.buscar(1L));
		System.out.println(petDAO.consultar(pet));
	}
}
