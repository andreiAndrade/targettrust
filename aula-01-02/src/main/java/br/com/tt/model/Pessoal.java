package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//@formatter:off
@Entity
@Table(name = "cliente", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "rg" }),
		@UniqueConstraint(columnNames = { "cpf" })
		})
//@formatter:on
public class Pessoal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String endereco;

	public Pessoal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoal(Long id, String nome, String rg, String cpf, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Pessoal(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoal [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", endereco=" + endereco + "]";
	}

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
