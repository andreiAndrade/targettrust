package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="cliente_seq", sequenceName="cliente_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	private Long id;
	
	private String cpf;
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	public Cliente() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + "]";
	}
	
	

}
