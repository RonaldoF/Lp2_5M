package com.senac.jogos.labirinto;

public class Jogador extends Personagem {

	private Arma arma;
	private Armadura armadura;
	private Chave chave;

	public Jogador() {
		super(1, 0, 20);
		this.arma = null;
		this.armadura = null;
		this.chave = null;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) throws Exception {
		if (this.arma != null)
			throw new Exception("O jogador já está equipado com uma "+arma.getDescricao());
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) throws Exception {
		if (this.armadura != null)
			throw new Exception("O jogador já está equipado com "+armadura.getDescricao());
		this.armadura = armadura;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) throws Exception
	{
		if (this.chave != null)
			throw new Exception("Jogador só pode pegar uma chave por vez");
		this.chave = chave;
	}
	
	public int getAtaque() {
		int bonus = 0;
		if (arma != null)
			bonus += arma.getDano();
		return ataque + bonus;
	}
	@Override
	public void setDano(int value) {
		int total = value - resistencia;
		if (armadura != null)
			total -= armadura.getResistencia();
		vida -= total;
	}

	public void matarJogador() {
		this.vida = 0;
	}

	public void soltarArmadura() {
		this.armadura = null;
	}

	public void soltarArma() {
		this.arma = null;
	}

	public void soltarChave() {
		this.chave = null;
	}

	
	public String toString() {
		int ataq = 0;
		ataq = ataque;

		int defesa = 0;
		defesa = resistencia;

		if (armadura != null) {
			defesa += armadura.getResistencia();
		}

		if (arma != null) {
			ataq += arma.getDano();
		}

		return "JOGADOR" + "\nVida: " + vida + "\nAtaque: " + ataq +"  "+statusArma()
				+ "\nDefesa: " + defesa + "  "+statusArmadura();
	}

	public String statusArma() {
		String semArma = "" ;
		if(this.arma==null){
			semArma += "";
		}else{
			semArma += "Equipado com "+arma.getDescricao();
		}
		return semArma;
	}

	public String statusArmadura() {
		String semArmadura = "";
		if(this.armadura==null){
			semArmadura += "";
		}else{
			semArmadura += "Equipado com "+armadura.getDescricao();
		}
		return semArmadura;
	}
}
