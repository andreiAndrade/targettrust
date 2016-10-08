package br.com.tt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Compra {

	@Id
	@SequenceGenerator(name = "compra_seq", sequenceName = "compra_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra_seq")
	private Long id;

	private Double valorTotal;
	private int numeroProdutos;

	public Compra() {
		super();
	}

	public Compra(Double valorTotal, int numeroProdutos) {
		this.valorTotal = valorTotal;
		this.numeroProdutos = numeroProdutos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getNumeroProdutos() {
		return numeroProdutos;
	}

	public void setNumeroProdutos(int numeroProdutos) {
		this.numeroProdutos = numeroProdutos;
	}

}
