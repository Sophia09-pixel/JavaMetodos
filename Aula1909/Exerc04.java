package Aula1909;

import java.util.Scanner;

public class Exerc04 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int chamado[][] = chamado();
		relatorio(chamado);

		int contCrit[] = contadorCriterios(chamado);
		
		exibeCriterio(contCrit);
	}

	public static int[][] chamado() {
		int chamado[][] = new int[5][3];

		for (int i = 0; i < 5; i++) {
			System.out.println("Digite a identificação do " + (i + 1) + "° funcionário: ");
			chamado[i][0] = entrada.nextInt();
			System.out.println("Digite o código o " + (i + 1) + "° código de erro: ");
			chamado[i][1] = entrada.nextInt();
			while (chamado[i][1] < 1 || chamado[i][1] > 3) {
				System.out.println("Digite 1/2/3");
				chamado[i][1] = entrada.nextInt();
			}
			System.out.println("Digite o critério da " + (i + 1) + "° chamada: ");
			chamado[i][2] = entrada.nextInt();
			while (chamado[i][2] < 1 || chamado[i][2] > 4) {
				System.out.println("Digite 1/2/3/4");
				chamado[i][2] = entrada.nextInt();
			}
			System.out.println("");
		}

		return chamado;
	}

	public static void relatorio(int chamado[][]) {
		int contadorErro[] = new int[3];
		System.out.println("--- RELATORIO DE CHAMADO POR ERRO ---");

		for (int i = 0; i < chamado.length; i++) {
			int codErro = chamado[i][1] - 1;
			contadorErro[codErro]++;
		}

		for (int i = 0; i < contadorErro.length; i++) {
			System.out.println("Número de chamados com o código de erro " + (i + 1) + ": " + contadorErro[i]);
		}
	}

	public static int[] contadorCriterios(int chamado[][]) {
		int contCrit[] = new int[4];

		for (int i = 0; i < chamado.length; i++) {
			int crit = chamado[i][2] - 1;
			contCrit[crit]++;
		}

		return contCrit;
	}

	public static void exibeCriterio(int contCrit[]) {
		String tipoCrit[] = new String[]{"Sistema Parado","Grave","Não Grave","Dúvida"};
		System.out.println("");
		System.out.println("--- RELATORIO DE CHAMADOS POR CRITERIO ---");
		
		for(int i=0;i<4;i++) {
			System.out.println("Números de chamadas - "+tipoCrit[i]+": "+contCrit[i]);
		}
	}
}