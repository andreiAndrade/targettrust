package br.com.tt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({ 
	@NamedQuery(name = Cliente.QUERY_LISTA, query = "SELECT c FROM Cliente c"),
	@NamedQuery(name = Cliente.QUERY_LISTA_BY_NOME, query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome"),
	@NamedQuery(name = Cliente.QUERY_LISTA_BY_NOME_AND_DATANASC, query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome AND dataNasc < :dataNasc")
})
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SEQ = "cliente_seq";

	public static final String QUERY_LISTA = "cliente.lista";
	
	public static final String QUERY_LISTA_BY_NOME = "cliente.lista.by.nome";

	public static final String QUERY_LISTA_BY_NOME_AND_DATANASC = "cliente.lista.by.nome.and.dataNasc";
	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	private Long id;

	private String nome;

	private String cpf;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Endereco> enderecos;

	@Temporal(TemporalType.DATE)
	private Calendar dataNasc;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void addEndereco(Endereco endereco) {
		if (Objects.isNull(endereco)) {
			return;
		}
		if (Objects.isNull(this.enderecos)) {
			this.enderecos = new ArrayList<>();
		}
		this.enderecos.add(endereco);
		endereco.setCliente(this);
	}

	public void addCidade(String cidade) {
		if (Objects.isNull(cidade)) {
			return;
		}
		if (Objects.isNull(this.enderecos)) {
			this.enderecos = new ArrayList<>();
		}
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		this.enderecos.add(endereco);
		endereco.setCliente(this);
	}
}
