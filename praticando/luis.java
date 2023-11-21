package praticando;

import java.text.DecimalFormat;
import java.util.Scanner;

public class luis {

	static Scanner entrada = new Scanner(System.in);

	static DecimalFormat formata = new DecimalFormat("R$ #,##0.00");

	public static void main(String[] args) {

		String[] arrayCarro = new String[] { "Uno", "Palio", "Siena", "Bravo", "Strada", "Idea" };

		double[] arrayPreco = new double[] { 25370, 26490, 30000, 56800, 36200, 43890 };

		int vendas[][] = vendasTri(arrayCarro);

		int qtdCarros[] = qtdVendidaCarros(vendas);

		double totalVendido[] = totalVendas(arrayPreco, qtdCarros);

		int totalTri[] = somaTri(vendas);

		relatorioGerencial(arrayCarro, arrayPreco, qtdCarros, totalVendido, totalTri);
	
		ranking(totalVendido,arrayCarro);
	}

	static public int[][] vendasTri(String[] arrayCarro) {
		int vendas[][] = new int[3][6];
		System.out.println("----- Controle de vendas fiat 2014 -----");
		for (int i = 0; i < 3; i++) {
			System.out.println("");
			System.out.println("Vendas " + (1 + i) + "° Tri");
			for (int j = 0; j < 6; j++) {
				System.out.println("Carro: " + arrayCarro[j]);
				vendas[i][j] = entrada.nextInt();
			}
		}

		return vendas;
	}

	static public int[] qtdVendidaCarros(int[][] vendas) {
		int qtdCarros[] = new int[6];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				qtdCarros[j] += vendas[i][j];
			}
		}

		return qtdCarros;
	}

	static public double[] totalVendas(double[] arrayPreco, int qtdCarros[]) {
		double totalVendido[] = new double[6];

		for (int i = 0; i < 6; i++) {
			totalVendido[i] = qtdCarros[i] * arrayPreco[i];
		}

		return totalVendido;
	}

	static public int[] somaTri(int vendas[][]) {
		int totalTri[] = new int[3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				totalTri[i] += vendas[i][j];
			}
		}

		return totalTri;
	}

	static public void relatorioGerencial(String[] arrayCarro, double[] arrayPreco, int qtdCarros[],
			
			double totalVendido[], int totalTri[]) {
		int totalGeral=0;
		System.out.println("=== Relatório Gerencial ===");
		for (int i = 0; i < 6; i++) {
			totalGeral+=totalVendido[i];
			System.out.println("Carro: " + arrayCarro[i] + " - Quantidade Geral: " + qtdCarros[i] + " - Total R$: "
					+ formata.format(totalVendido[i]));
		}
		System.out.println("Total Geral de Vendas 2014"+ formata.format(totalGeral));
		System.out.println("");
		System.out.println("=== Total de Vendas por Trimestre ===");
		for (int i = 0; i < 3; i++) {
			System.out.println((1 + i) + "° TRI total de carros vendidos: " + totalTri[i]);
		}

	}

	static public void ranking(double[] totalVendido,String[]arrayCarro) {
		String auxNome;
		double aux=0;
		
		for(int i =0;i<6;i++) {
			for(int j =0;j<5;j++) {
				if (totalVendido[j] < totalVendido[j + 1]) {
                    aux = totalVendido[j];
                    totalVendido[j] = totalVendido[j + 1];
                    totalVendido[j + 1] = aux;

                    auxNome = arrayCarro[j];
                    arrayCarro[j] = arrayCarro[j + 1];
                    arrayCarro[j + 1] = auxNome;
                }	
			}	
		}
		
		System.out.println("=== Ranking ===");
		for(int i =0;i<6;i++) {
			System.out.println((i+1)+"° "+arrayCarro[i]);
		}
	}
}
