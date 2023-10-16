package Aula1909;

import java.util.Scanner;

public class Exerc07 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String linhas[] = new String[]{"Notebook","Computadores","Tablets","Servidores"};
		int meta[] = new int[] {100,150,200,250};
		int vendas[][] =prodVendidos(linhas);
		
		int totalPorLinha[] = qtdProdVendidos(vendas);
		
		for(int i =0;i<4;i++) {
			System.out.println("Total da linha de "+linhas[i]+" - "+totalPorLinha[i]);	
		}
		
		System.out.println("");
		
		int totalPorTrimestre[] = verificaPorTrimestre(vendas);
		for(int i =0;i<3;i++) {
			System.out.println("Total de vendas no "+(i+1)+"° Trimestre: "+totalPorTrimestre[i]);
		}
		
		System.out.println("");
		
		String resultadoMeta[] = verificaMeta(totalPorLinha,meta);
		for(int i =0;i<4;i++) {
			System.out.println("Produto - "+linhas[i]+" - "+resultadoMeta[i]);
		}
	}
	
	public static int[][] prodVendidos(String linhas[]) {
		int vendas[][] = new int[4][3];
		for(int i =0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.println("Digite a quantidade de vendas do produto: "+linhas[i]+" no "+(j+1)+" trimestre");
				vendas[i][j] = entrada.nextInt();
			}
		}
		return vendas;
	}

	public static int[] qtdProdVendidos(int vendas[][]) {
		int totalPorLinha[] = new int[4];
		for(int i =0;i<4;i++) {
			for(int j=0;j<3;j++) {
				totalPorLinha[i] += vendas[i][j];
			}
		}
		return totalPorLinha;
	}
	
	public static int[] verificaPorTrimestre(int vendas[][]) {
		int totalPorTrimestre[] = new int[3];
		for(int i =0;i<4;i++) {
			for(int j =0;j<3;j++) {
				totalPorTrimestre[j] += vendas[i][j]; 
			}
		}
		return totalPorTrimestre;
	}

	public static String[] verificaMeta(int totalPorLinha[],int meta[]) {
		String resultadoMeta[] = new String[4];
		
		for(int i =0;i<4;i++) {
			if(totalPorLinha[i]>=meta[i]) {
				resultadoMeta[i] = "Atingiu a Meta";
			}else {
				resultadoMeta[i] = "Não Atingiu a Meta";
			}
		}
		
		return resultadoMeta;
	}

}
