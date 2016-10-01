package br.com.tt.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Cliente {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String curso;
	private String turma;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
