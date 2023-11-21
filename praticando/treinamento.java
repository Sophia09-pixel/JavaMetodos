package praticando;

import java.util.Scanner;

public class treinamento {

	static Scanner entrada = new Scanner(System.in);
	static String candidatos[] = new String[] { "João Carlos", "José Silva" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regioes[] = new String[] { "Sul", "Sudeste", "Norte", "Nordeste" };

		int votos[][] = votacao(regioes);

		int somaVotos[] = verificaVotos(votos);
		
		maiorRegiao(regioes,votos);
		
		maiorCanditado(somaVotos);
	}

	public static int[][] votacao(String regioes[]) {
		int votos[][] = new int[2][4];

		for (int i = 0; i < 2; i++) {
			System.out.println("Candidato: " + candidatos[i]);
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.println("votos na região " + regioes[j]);
				votos[i][j] = entrada.nextInt();
			}
		}
		return votos;
	}

	public static int[] verificaVotos(int votos[][]) {
		int somaVotos[] = new int[2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				somaVotos[i] += votos[i][j];
			}
		}
		return somaVotos;
	}

	public static void maiorRegiao(String regioes[],int votos[][]) {
		int maiorVoto=0;
		String maiorRegiao[] = new String[2];
		String candMaior="";
		
		for(int i =0;i<2;i++) {
			 maiorVoto=0;
			 candMaior="";
			for(int j=0;j<4;j++) {
				if(votos[i][j]>maiorVoto) {
					maiorVoto = votos[i][j];
					candMaior = regioes[j];
				}
				maiorRegiao[i] = candMaior;
			}
		}
		
		for(int i =0;i<2;i++) {
			System.out.println(candidatos[i]+" maior voto na Região - "+maiorRegiao[i]);
		}
	}

	public static void maiorCanditado(int somaVotos[]) {
		int maiorVoto=0;
		String maiorCandidato="";
		
	   for(int i =0;i<2;i++) {
		   if(somaVotos[i]>maiorVoto) {
			   maiorVoto = somaVotos[i];
			   maiorCandidato = candidatos[i];
		   }
	   }
	   System.out.println("Maior candidato por votos - "+maiorCandidato);
	}
}
