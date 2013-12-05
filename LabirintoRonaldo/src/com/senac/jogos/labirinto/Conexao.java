package com.senac.jogos.labirinto;
public class Conexao {
	private int sala;
	private Inimigo inimigo;
	private Cor cor;
	
	public Conexao(int sala)
	{
		this.sala = sala;
		this.cor = setRandomColor();
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public Inimigo getInimigo() {
		return inimigo;
	}

	public void setInimigo(Inimigo inimigo) {
		this.inimigo = inimigo;
	}
	
	public void setArmadilha() {
		this.inimigo = new Armadilha();
	}

	public void setCor(Cor cor) {
		if (cor != null)
			this.cor = cor;
	}
	
	public Cor getCor(){
		return cor;
	}
	
	public boolean canAtravessar(Jogador jogador)
	{
		if (cor != Cor.MARROM) {
			Chave c = jogador.getChave();
			if (c != null)
				return c.getCor() == cor;
			else
				return false;
		}
		
		if (inimigo != null) {
			if (! (inimigo instanceof Armadilha))
				return !inimigo.isAlive();
		}
		
		return true;
	}

	private Cor setRandomColor(){
		if(Range.getPercentual() > 60){
			switch (new Range(1,4).getRandom()) {
				case 1: return Cor.AMARELA;
				case 2: return Cor.AZUL;
				case 3: return Cor.VERDE;
				case 4: return Cor.VERMELHA;
			}
		}
		return Cor.MARROM;
	}
	
	
	public String toString()
	{
		String  res= "Porta " + cor;
		if (inimigo != null && !(inimigo instanceof Armadilha))
			res += " guardada por um " + inimigo;
		return res;
	}

	public String getInfo() {
		String res = "Porta " + cor;
		if (inimigo != null)
			res += " guardada por um " + inimigo+"\nAtaque: "+inimigo.ataque+"\nVida: "+inimigo.vida;
		return res;
	}

	
}
