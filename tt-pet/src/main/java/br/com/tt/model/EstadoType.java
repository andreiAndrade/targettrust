package br.com.tt.model;

public enum EstadoType {
	RS("Rio Grande do Sul"), 
	SC("Santa Catarina"), 
	PR("Paran�"),
	SP("S�o Paulo"), 
	RJ("Rio de Janeiro");
	
	private String descricao;
	
	private EstadoType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
