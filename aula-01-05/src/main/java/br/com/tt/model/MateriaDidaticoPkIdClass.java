package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MateriaDidaticoPkIdClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String curso;
	private Integer versao;

	public MateriaDidaticoPkIdClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MateriaDidaticoPkIdClass(String curso, Integer versao) {
		super();
		this.curso = curso;
		this.versao = versao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Override
	public String toString() {
		return "MateriaDidaticoPkIdClass [curso=" + curso + ", versao=" + versao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		MateriaDidaticoPkIdClass other = (MateriaDidaticoPkIdClass) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

}
