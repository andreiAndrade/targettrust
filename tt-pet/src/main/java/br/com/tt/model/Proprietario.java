package br.com.tt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.tt.exception.PetException;
import br.com.tt.exception.PetExceptionType;
import br.com.tt.utilitario.cpf.CpfValidate;

@Entity
public class Proprietario {

	private static final String SEQ = "proprietario_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true, length = 11)
	private String cpf;

	@OneToMany(mappedBy = "proprietario", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Telefone> telefones;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Endereco endereco;

	@OneToMany(mappedBy = "proprietario")
	private List<Pet> pet;

	public void addTelefone(Telefone telefone) {
		if (!Objects.isNull(telefone)) {
			if (Objects.isNull(telefones)) {
				telefones = new ArrayList<Telefone>();
			}
			telefones.add(telefone);
			telefone.setProprietario(this);
		}
	}

	public void addPet(Pet pet) {
		if (!Objects.isNull(pet)) {
			if (Objects.isNull(this.pet)) {
				this.pet = new ArrayList<Pet>();
			}
			this.pet.add(pet);
			pet.setProprietario(this);
		}
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws PetException {
		if (!CpfValidate.validate(cpf)) {
			throw new PetException(PetExceptionType.CPF_INVALIDO);
		}
		this.cpf = cpf;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
