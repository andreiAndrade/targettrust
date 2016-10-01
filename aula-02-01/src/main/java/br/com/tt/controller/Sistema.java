package br.com.tt.controller;

import br.com.tt.dao.ClienteDAO;
import br.com.tt.model.Cliente;
import br.com.tt.model.Reserva;

public class Sistema {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Pedro Silva");
		cliente.setCpf("03201846090");

		Reserva reserva = new Reserva();
		reserva.setDias(5);
		reserva.setValor(1500D);
		
		cliente.addReserva(reserva);
		
		new ClienteDAO().salvar(cliente);
		
		System.out.println(cliente.getId() + " - " + cliente.getNome());
		System.exit(0);
		
	}
}
