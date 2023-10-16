package Aula1909;

import java.util.Scanner;

public class exemplo08 {

	static Scanner entrada = new Scanner(System.in);
	static String produtos[] = new String[] { "Computador", "notebook", "Tablet" };
	static String meses[] = new String[] { "Jan", "Fev", "Mar" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vendas[][] = carregar();
		int somaProd[] = somaProdutos(vendas);
		int somaMe[] = somaMes(vendas);

		relatorio(somaProd, somaMe);
	}

	public static int[][] carregar() {
		int vendas[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			System.out.println(produtos[i]);
			for (int j = 0; j < 3; j++) {
				System.out.println("Qtd mes " + meses[j] + ": ");
				vendas[i][j] = entrada.nextInt();
			}
		}

		return vendas;
	}

	public static int[] somaProdutos(int[][] vendas) {
		int somaProd[] = new int[3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				somaProd[i] += vendas[i][j];
			}
		}
		return somaProd;
	}

	public static int[] somaMes(int[][] vendas) {
		int somaMe[] = new int[3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				somaMe[i] += vendas[j][i];
			}
		}
		return somaMe;
	}

	public static void relatorio(int somaProd[], int somaMe[]) {
		System.out.println("");
		System.out.println("Relatório");
		System.out.println("Total Produtos");
		for (int i = 0; i < 3; i++) {
			System.out.println(produtos[i] + " - total:" + somaProd[i]);
		}
		System.out.println("");
		System.out.println("Total Mes");
		for (int i = 0; i < 3; i++) {
			System.out.println(meses[i] + " - total:" + somaMe[i]);
		}
	}

}
