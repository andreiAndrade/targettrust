package br.com.tt.exception;

public enum PetExceptionType {
	CPF_INVALIDO("Cpf inválido");

	private String descricao;

	PetExceptionType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
