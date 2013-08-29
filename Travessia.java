import java.util.Scanner;


public class Travessia {

	String comando = "";
	int TAMANHO=10;
	int[] mapa = new int[TAMANHO];
	int combustivel = 6;
	int posicao = 0;
	public static void main(String[] args) {
		String opc = "";
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Travessia caminhao = new Travessia();
		//comando = scan.nextLine().toUpperCase();
		//System.out.println("posi��o "+posicao+"\ngasolina "+combustivel);
		System.out.println("TRAVESSIA DO DESERTO\n\n\n" +
				"Voce esta em um acampamento e tem que atravessar um deserto\n" +
				"seu caminhao possui 6 unidades de gasolina, e para se locomover\n" +
				"ele utiliza uma unidade de combustivel, voce pode largar uma unidade\n" +
				"de combustivel durante o percurso para recarregar mais tarde.\n" +
				"No acampamento inicial o combustivel � ilimitado e seu caminhao\n" +
				"reabastece por completo.");
		do {	
			System.out.println("\n\nPara movimentar digite:\n" +
					"AVANCAR, VOLTAR, CARREGAR, DESCARREGAR\nPara mais digite REGRAS\n\n");
			opc = scan.next();

			if(opc.equalsIgnoreCase("avancar")||opc.equals("3")){
				caminhao.avancar();
				System.out.println("O caminhao andou uma posicao no mapa\n_______________________________________\n");
				System.out.println(caminhao.showme());
			}
			else if(opc.equalsIgnoreCase("voltar")||opc.equals("1")){
				caminhao.voltar();
				if(caminhao.posicao==0){
					System.out.println("Caminhao esta na posicao inicial\n_______________________________________\n");
				}else{
					System.out.println("O caminhao voltou uma posicao no mapa\n_______________________________________\n");
				}
				System.out.println(caminhao.showme());
			}
			else if(opc.equalsIgnoreCase("carregar")||opc.equals("5")){
				caminhao.carregar();
				System.out.println("O caminhao reabasteceu\n_______________________________________\n");
				System.out.println(caminhao.showme());
			}
			else if(opc.equalsIgnoreCase("descarregar")||opc.equals("2")){
				caminhao.descarregar();
				System.out.println(caminhao.showme());
			}
			else if(opc.equalsIgnoreCase("regras")||opc.equals("0")){
				System.out.println(caminhao.regras());
			}

		} while (true);
	}
	public void avancar() {
		if(combustivel>0){
			posicao++;
			combustivel--;
		}
		else if(posicao==0){
			System.out.println("Combustivel at� a boca");
			combustivel = 6;
		}
		else if(posicao==9){
			System.out.println("GANHOU!");
			System.exit(0);
		}
		else if((combustivel==0)&&(posicao!=0)){
			System.out.println("\nPERDEU!");
			System.exit(0);
		}
	}
	public void voltar() {
		if((combustivel>0)&&(posicao!=0)){
			posicao--;
			combustivel--;
			if(posicao==0){
				combustivel=6;
			}
			if((posicao!=0)&&(combustivel==0)){
				System.out.println("\nPERDEU!");
				System.exit(0);
			}
		}
	}
	public void descarregar() {


		if((combustivel>0) && (posicao > 0)){
			if((mapa[posicao]<6)){
				combustivel--;
				mapa[posicao]++;
				System.out.println("O caminhao descarregou um tanque de combustivel na posicao no mapa\n_______________________________________\n");

			}else{
				System.out.println("Maximo de combustivel para essa posicao\n_______________________________________\n");
			}
		}
	}


	public void carregar() {
		if((posicao == 0)){
			combustivel=6;
		}

		if(mapa[posicao]>0){
			if(combustivel>6){
				combustivel++;
				mapa[posicao]--;
			}else{
				combustivel=6;
			}
		}




	}
	public String regras(){
		String reg = "\n____________________________________________________________________\n" +
				"REGRAS:\n" +
				"avancar - (avanca para proxima posicao, gasta 1 de combustivel)" +
				"\nvoltar - (volta uma posicao, gasta 1 de combustivel)" +
				"\ncarregar - (recarrega combustivel se previamente estiver descarregado no mapa)" +
				"\ndescarregar - (larga combustivel durante o percurso" +
				"\n____________________________________________________________________\n";
		return reg;
	}


	public String showme(){
		String st = "\nSTATUS";
		if(posicao==0){
			st+="\nInicio, caminhao reabastecido";
		}else{

			st += "\n"+posicao+"� posicao";
		}
		st += "\nGasolina: "+combustivel+
				"\nCombustivel nesta posicao do mapa: "+mapa[posicao];
		return st;

	}

}
