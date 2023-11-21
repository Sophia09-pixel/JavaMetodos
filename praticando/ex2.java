package praticando;

import java.util.Scanner;

public class ex2 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String linhas[] = new String[] {"Notebooks","Computadores","Tablets","Servidores"};
		int meta[] = new int[] {100,150,200,250};
	
		int vendas[][] = prodVendidos(linhas);
		
		int totalLinha[] = totalVendidoPorLinha(vendas);
		System.out.println("--------------------------------------------------------");
		for(int i =0;i<4;i++) {
			System.out.println("Total de vendas da linha de "+linhas[i]+" - "+totalLinha[i]);
		}
		int totalTri[] = totalPorTrimestre(vendas);
		System.out.println("--------------------------------------------------------");
		for(int i =0;i<3;i++) {
			System.out.println("Total de vendas no "+(i+1)+"° trimestre: "+totalTri[i]);
		}
		System.out.println("--------------------------------------------------------");
		String resultMeta[] = atingiuMeta(totalLinha, meta);
		for(int i =0;i<4;i++) {
			System.out.println(linhas[i]+" - "+resultMeta[i]);
		}
	}
	
	public static int[][] prodVendidos(String linhas[]){
		int vendas[][] = new int[4][3];
		for(int i =0;i<4;i++) {
			System.out.println("===========================");
			System.out.println("Vendas de ("+linhas[i]+")");
			for(int j=0;j<3;j++) {
				System.out.print((j+1)+"° Trimestre: ");
				vendas[i][j] = entrada.nextInt();
			}
		}
		
		return vendas;
		
	}

	public static int[] totalVendidoPorLinha(int vendas[][]) {

		int totalLinha[] = new int[4];
		for(int i =0;i<4;i++) {
			for(int j=0;j<3;j++) {
				totalLinha[i] += vendas[i][j];
			}
		}
		
		return totalLinha;
	}

	public static int[] totalPorTrimestre(int vendas[][]) {
		int totalTri[] = new int[3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				totalTri[i] += vendas[j][i];
			}
		}
		
		return totalTri;
	}

	public static String[] atingiuMeta(int totalLinha[],int meta[] ) {
		String resultMeta[] = new String[4];
		
		for(int i =0;i<4;i++) {
			if(totalLinha[i]>=meta[i]) {
				resultMeta[i] = "Atingiu a Meta";
			}else {
				resultMeta[i] = "Não atingiu a Meta";
			}
		}
		
		return resultMeta;
	}
}
