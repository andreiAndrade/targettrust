package br.com.tt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "reserva_seq", sequenceName = "reserva_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_seq")
	private Long id;

	private Integer dias;
	private Double valor;
	@ManyToMany
	@JoinTable(
			name="RESERVA_CLIENTE", 
			joinColumns={
					@JoinColumn(name="RESERVA_ID")
					},
			inverseJoinColumns={
					@JoinColumn(name="CLIENTE_ID")
					}
			)
	private List<Cliente> clientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void addCliente(Cliente cliente) {
		if (Objects.isNull(this.clientes)) {
			this.clientes = new ArrayList<>();
		}
		this.clientes.add(cliente);
	}
}
