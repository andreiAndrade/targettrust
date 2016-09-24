package br.com.tt.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Pet {
	
	@Id
	@SequenceGenerator(
			name="pet_seq", 
			sequenceName="pet_seq", 
			allocationSize=1)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE, 
			generator="pet_seq")
	private Long id;
	@Column(name="apelido", 
			nullable=true, 
			length=20, 
			updatable=true)
	private String nome;
	private Double peso;
	private Double altura;
	
	@Transient
	private Integer idade;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Calendar dataNasc;
	
	private Boolean vivo;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String nome) {
		super();
		this.nome = nome;
	}

	public Pet(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public Pet(String nome, Double peso, Double altura, Calendar dataNasc) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.dataNasc = dataNasc;
	}

	public Pet(String nome, Double peso, Double altura, Integer idade, Calendar dataNasc) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.dataNasc = dataNasc;
	}
	
	public Boolean getVivo() {
		return vivo;
	}

	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", peso=" + peso + ", altura=" + altura + ", idade=" + idade
				+ ", dataNasc=" + dataNasc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}
}
