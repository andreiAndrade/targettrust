package br.com.tt.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Pet {

	private static final String SEQ = "pet_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	private Long id;

	private String nome;

	private LocalDate dataNasc;
	@Transient
	private LocalDate dataNascIni;
	@Transient
	private LocalDate dataNascFim;

	public Long getIdade() {
		return dataNasc == null ? null : ChronoUnit.YEARS.between(dataNasc, Instant.now());
	}

	@Enumerated(EnumType.STRING)
	private EspecieType especie;

	private String raca;

	@ManyToOne(cascade=CascadeType.ALL)
	private Proprietario proprietario;
	
	@Version
	private Integer versao;

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

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public LocalDate getDataNascIni() {
		return dataNascIni;
	}

	public void setDataNascIni(LocalDate dataNascIni) {
		this.dataNascIni = dataNascIni;
	}

	public LocalDate getDataNascFim() {
		return dataNascFim;
	}

	public void setDataNascFim(LocalDate dataNascFim) {
		this.dataNascFim = dataNascFim;
	}

	public EspecieType getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieType especie) {
		this.especie = especie;
	}

	public Integer getVersao() {
		return versao;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
}
