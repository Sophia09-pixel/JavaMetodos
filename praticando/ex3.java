package praticando;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ex3 {
	static DecimalFormat numFormatado = new DecimalFormat("#,##0.00");
	static Scanner entrada = new Scanner(System.in);
	static String[][] hospedeDados = new String[5][2];
	static int[][] hospedeNumero = new int[5][2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String nomeProduto[] = new String[] { "Refrigerante Lata", "Água sem gás", "Água com gás", "Suco de Laranja",
				"Barra de chocolate" };

		double[] PrecoProduto = new double[] { 2.80, 1.90, 2.10, 2.30, 4.90 };

		String[] nomeServico = new String[] { "Lavanderia", "Sauna", "Almoço", "Café da Manhã", "Jantar" };

		double[] precoServico = new double[] { 10.50, 60.80, 42.90, 35.60, 60.40 };

		System.out.println("----- HOTEL BOA VIAJEM -----");
		for (int i = 0; i < 5; i++) {
				System.out.print("Nome do Cliente: ");
				hospedeDados[i][0] = entrada.next();

				System.out.print(
						"Tipo da acomodação: S(single) - D(double) - SL(Suite de Luxo) - SR(Suite Presidencial): ");
				hospedeDados[i][1] = entrada.next();
				while (!(hospedeDados[i][1].equalsIgnoreCase("S") || hospedeDados[i][1].equalsIgnoreCase("D")
						|| hospedeDados[i][1].equalsIgnoreCase("SL") || hospedeDados[i][1].equalsIgnoreCase("SR"))) {

					System.out.println("Digite uma opção válida S/D/SL/SR");
					hospedeDados[i][1] = entrada.next();
				}

				System.out.print("Número do quarto: ");
				hospedeNumero[i][0] = i + 1;
				System.out.println(hospedeNumero[i][0]);

				System.out.print("Quantidade de diarias: ");
				hospedeNumero[i][1] = entrada.nextInt();
				System.out.println("----------------------------------");
			
		}
		
		System.out.println("--- Preencha o consumo de produtos por hospedagem ---");
		int prodConsumidos[][] = consumoProdutos(nomeProduto);
		
		System.out.println("--- Preencha o consumo de serviços por hospedagem ---");
		int servConsumido[][] = consumoServicos(nomeServico);
		
		double estadia[]=calculaEstadia();
		
		System.out.println("--- Relatório Gerencial ---");
		gerarRelatorioGerencial(prodConsumidos,servConsumido,PrecoProduto,precoServico,estadia);
	}
	
	public static int[][] consumoProdutos(String nomeProduto[]){
		int prodConsumidos[][] = new int[5][5];
		for(int i =0;i<5;i++) {
			System.out.println("---- HOSPEDAGEM "+(i+1));
			for(int j=0;j<5;j++) {
				System.out.print("Informe a quantidade de consumida do Produto ("+nomeProduto[j]+"): ");
				prodConsumidos[i][j] = entrada.nextInt();
			}
		}
		
		return prodConsumidos;
	}

	public static int[][] consumoServicos(String[] nomeServico){
		int servConsumido[][] = new int[5][5];
		for(int i =0;i<5;i++) {
			System.out.println("---- HOSPEDAGEM "+(i+1));
			for(int j=0;j<5;j++) {
				System.out.print("Informe a quantidade de consumida do Serviço ("+nomeServico[j]+"): ");
				servConsumido[i][j] = entrada.nextInt();
			}
		}
		
		return servConsumido;
	}

	public static double[] calculaEstadia() {
		double estadia[] = new double[5];
		for(int i =0;i<5;i++) {
			if(hospedeDados[i][1].equalsIgnoreCase("S")) {
				estadia[i] = hospedeNumero[i][1] * 245;
			}else {
				if(hospedeDados[i][1].equalsIgnoreCase("D")) {
					estadia[i] = hospedeNumero[i][1] * 280;
				}else {
					if(hospedeDados[i][1].equalsIgnoreCase("SL")) {
						estadia[i] = hospedeNumero[i][1] * 310;
					}else {
						if(hospedeDados[i][1].equalsIgnoreCase("SR")) {
							estadia[i] = hospedeNumero[i][1] * 400;
						}
					}
				}
			}
		}
		return estadia;
	}

	public static void gerarRelatorioGerencial(int prodConsumidos[][],int servConsumido[][] ,double[] PrecoProduto,double[] precoServico,double[] estadia) {

		double totalServico[] = new double[5];
		double totalProduto[] = new double[5];

		for(int i =0;i<5;i++) {
			for(int j =0;j<5;j++) {
				totalServico[i] = precoServico[j] * servConsumido[i][j];
				totalProduto[i] = PrecoProduto[j] * prodConsumidos[i][j];
			}
			
		}
		double totalGeral[] = new double[5];
		
		
		for(int i =0;i<5;i++) {
			totalGeral[i] = totalServico[i] + totalProduto[i] + estadia[i];
			System.out.println("Número do Quarto: "+hospedeNumero[i][0]);
			System.out.println("Nome do Cliente: "+hospedeDados[i][0]);
			System.out.println("Tipo de Acomodação: "+hospedeDados[i][1]);
			System.out.println("Quantidade de diárias: "+hospedeNumero[i][1]);
			System.out.println("Valor total da diária R$: "+estadia[i]);
			System.out.println("-----------------------------------------------");
		}
		
		
		System.out.println("---- Relatório Gerencial -----");
		System.out.println("QUARTO |       CLIENTE |  TOTAL DIÁRIAS |  TOTAL SERVIÇO |  TOTAL PRODUTO | TOTAL GERAL");
		for(int i =0;i<5;i++) {
			System.out.print(hospedeNumero[i][0]);
			System.out.print("\t\t"+hospedeDados[i][0]);
			System.out.print("\t\t"+estadia[i]);
			System.out.print("\t\t"+numFormatado.format(totalServico[i]));
			System.out.print("\t\t"+numFormatado.format(totalProduto[i]));
			System.out.print("\t\t"+numFormatado.format(totalGeral[i]));
			System.out.println("");
		}
	}
}
