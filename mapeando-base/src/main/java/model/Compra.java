package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPRA_ID_GENERATOR", sequenceName="COMPRA_SEQ")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="COMPRA_ID_GENERATOR")
	private Long id;

	@Column(name="numero_produtos")
	private Integer numeroProdutos;

	@Column(name="valor_total")
	private double valorTotal;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public Compra() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroProdutos() {
		return this.numeroProdutos;
	}

	public void setNumeroProdutos(Integer numeroProdutos) {
		this.numeroProdutos = numeroProdutos;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}