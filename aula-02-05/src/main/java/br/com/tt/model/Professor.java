package br.com.tt.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String pisPasep;
	private Double salario;

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
