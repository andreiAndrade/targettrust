package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	private Long id;

	@Column(length = 3, nullable = false)
	private String ddd;

	@Column(length = 9, nullable = false)
	private String numero;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
