package br.com.tt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pet {

	@Id
	@SequenceGenerator(name = "pet_seq", sequenceName = "pet_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
	private Long id;
	
	private String nome;
	
	private String proprietario;
	
	private String raca;
	
	private String especie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Pet(String nome, String proprietario, String raca, String especie) {
		super();
		this.nome = nome;
		this.proprietario = proprietario;
		this.raca = raca;
		this.especie = especie;
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
