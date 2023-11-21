package praticando;

import java.text.DecimalFormat;
import java.util.Scanner;

public class extra {

	static DecimalFormat formata = new DecimalFormat("R$ #,##0.00");
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[]modeloCarro = new String[]{"Uno","Palio","Siena","Bravo","Strada","Idea"};
 
		double[] preco=new double[]{25370,26490,30000,56800,36200,43890};
		
		
		int[][] vendas = qtdVendida(modeloCarro);
		
		int vendasTri[] = qtdVendidaTri(vendas);
		
		double valorTotal[] = calculaTotal( preco, vendasTri); 
		
		int totalTri[] = somaTri(vendas);
		
		relatorioGerencial(modeloCarro ,preco,vendasTri,valorTotal,totalTri);
		
		ranking(valorTotal,modeloCarro);
	}
	
	public static int[][] qtdVendida(String[]modeloCarro){
		int[][] vendas = new int [3][6];
		
		System.out.println("Controle de vendas FIAT 2014");
		for(int i =0;i<3;i++) {
			System.out.println("=== Vendas "+(1+i)+"° Trimestre ===");
			for(int j=0;j<6;j++) {
				System.out.println("Carro "+modeloCarro[j]);
				vendas[i][j] = entrada.nextInt();
			}
		}
		
		return vendas;
	}

	public static int[] qtdVendidaTri(int[][] vendas) {
		int vendasTri[] = new int[6];
		for(int i =0;i<3;i++) {
			for(int j=0;j<6;j++) {
				vendasTri[j] += vendas[i][j];
			}
		}
		
		return vendasTri;
	}

	public static double[] calculaTotal(double[] preco,int vendasTri[]) {
		double valorTotal[] = new double[6];
		
		for(int i =0;i<6;i++) {
			valorTotal[i] = vendasTri[i]*preco[i];
		}
		
		return valorTotal;
	}

	public static int[]  somaTri(int[][] vendas){
		int totalTri[] = new int[3];
		
		for(int i =0;i<3;i++) {
			for(int j=0;j<6;j++) {
				totalTri[i] += vendas[i][j];
			}
		}
		
		return totalTri;
	}

	public static void relatorioGerencial(String[]modeloCarro ,double[] preco,int[] vendasTri,double[] valorTotal,int[] totalTri) {
		System.out.println("=== Relatório Gerencial ===");
		for(int i =0;i<6;i++) {
			System.out.println("Carro: "+modeloCarro[i]+" - Quantidade Geral: "+vendasTri[i]+" - Total R$: "+formata.format(valorTotal[i]));
		}
		System.out.println("");
		System.out.println("=== Total de Vendas por Trimestre ===");
		for(int i =0;i<3;i++) {
			System.out.println((1+i)+"° TRI total de carros vendidos: "+totalTri[i]);
		}
	}

	public static void ranking(double[] valorTotal,String[]modeloCarro) {
		System.out.println("");
		System.out.println("=== Ranking dos Carros mais vendidos ===");
		double aux=0;
		String auxNome;
		for(int i =0;i<6;i++) {
			for(int j=0;j<5;j++) {
				 if (valorTotal[j] < valorTotal[j + 1]) {
	                    aux = valorTotal[j];
	                    valorTotal[j] = valorTotal[j + 1];
	                    valorTotal[j + 1] = aux;

	                    auxNome = modeloCarro[j];
	                    modeloCarro[j] = modeloCarro[j + 1];
	                    modeloCarro[j + 1] = auxNome;
	                }	
			}
		}
		
		for(int i =0;i<6;i++) {
			System.out.println((i+1)+"° "+modeloCarro[i]+ " - "+formata.format(valorTotal[i]));
		}
	}
}


