package com.senac.jogos.labirinto;

public enum Cor {
	VERMELHA("Vermelha"), 
	VERDE("Verde"), 
	AMARELA("Amarela"), 
	AZUL("Azul"), 
	MARROM("Marrom");

	private String descricao;

	
	private Cor(String desc) {
		this.descricao = desc;
	}

	
	public boolean equals(String s) {
		return descricao.equalsIgnoreCase(s);
	}

	
	public String toString() {
		return descricao;
	}
}
