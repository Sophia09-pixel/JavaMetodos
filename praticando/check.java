package praticando;

import java.text.DecimalFormat;
import java.util.Scanner;

public class check {

	static String pilotos[] = new String[] { "Daniel Ricciardo", "Kimi Raikkonen", "Lewis Hamilton",
			"Nico Rosberg", "Sebastian Vettel" };
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String paises[] = new String[] { "Belgica", "Italia", "Singapura", "Malasia", "Japão" };

		relatorioGerencial(paises);

	}
	
	public static void relatorioGerencial(String paises[]) {
		int pontos[][] = pontuacao(paises);
		
		int somaPontos[] = verificaPontos(pontos);
		
		String pilotoVencedorGp[] = verificaVencedorGp(pontos);
		System.out.println("Pilotos Vencedores por GP");
		System.out.println("");
		for(int i =0;i<5;i++) {
			System.out.println("Vencedor do GP "+paises[i]+" - "+pilotoVencedorGp[i]);
		}
		
		maiorPonto(somaPontos);
	}
	
	public static int[][] pontuacao(String paises[]){
		int pontos[][] = new int[5][5];
		
		for(int i =0;i<5;i++) {
			System.out.println("Piloto ("+pilotos[i]+")");
			System.out.println("");
			for(int j=0;j<5;j++) {
				System.out.println("Pontos no GP: "+paises[j]);
				pontos[i][j] = entrada.nextInt();
			}
		}
		
		return pontos;
	}

	public static int[] verificaPontos(int pontos[][]) {
		int somaPontos[] = new int[5];
		for(int i =0;i<5;i++) {
			for(int j =0;j<5;j++) {
				somaPontos[i] += pontos[i][j];
			}
		}
		return somaPontos;
	}

	public static String[] verificaVencedorGp(int pontos[][]) {
		String pilotoVencedorGp[] = new String[5];
		int maiorPonto=0;
		String maiorPiloto="";
			
		for(int i =0;i<5;i++) {
			maiorPonto=0;
			maiorPiloto="";
			for(int j=0;j<5;j++) {
				if(pontos[j][i]>maiorPonto) {
					maiorPonto = pontos[j][i];
					maiorPiloto= pilotos[j];
				}
				pilotoVencedorGp[i] = maiorPiloto;
			}
		}
		
		
		return pilotoVencedorGp;
	}

	public static void maiorPonto(int somaPontos[]) {
		int maiorPonto=0;
		String maiorPiloto="";
		
		for(int i =0;i<5;i++) {
			if(somaPontos[i]>maiorPonto) {
				maiorPonto = somaPontos[i];
				maiorPiloto = pilotos[i];
			}
		}
		
		System.out.println("Piloto com maior pontuacao - "+maiorPiloto);
		
		System.out.println();
		System.out.println("Ranking");
		int aux=0;
		String auxPiloto="";
		for(int i =0;i<5;i++) {
			for(int j=0;j<4;j++) {
				if(somaPontos[j]<somaPontos[j+1]) {
					aux = somaPontos[j];
					somaPontos[j] = somaPontos[j+1];
					somaPontos[j+1] = aux;
					
					auxPiloto = pilotos[j];
					pilotos[j] = pilotos[j+1];
					pilotos[j+1] = auxPiloto;
				}
			}
		}
		
		for(int i =0;i<5;i++) {
			System.out.println((i+1)+" Lugar - "+pilotos[i]+" - "+somaPontos[i]);
		}
	}
}
