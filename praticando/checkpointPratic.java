package praticando;

import java.text.DecimalFormat;
import java.util.Scanner;

public class checkpointPratic {
	static DecimalFormat numFormatado = new DecimalFormat("#,##0.00");
	static Scanner entrada = new Scanner(System.in);

	static String[][] arrayDados = new String[5][2];

	static int[][] arrayNumero = new int[5][2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arrayNomeProduto = new String[] { "Refrigerante Lata", "Água sem gás", "Água com gás",
				"Suco de Laranja", "Barra de Chocolate" };

		double[] arrayPrecoProduto = new double[] { 2.80, 1.90, 2.10, 2.30, 4.90 };

		String[] arrayNomeServico = new String[] { "Lavanderia", "Sauna", "Almoço", "Café da Manhã", "Jantar" };

		double[] arrayPrecoServico = new double[] { 10.50, 60.80, 42.90, 35.60, 60.40 };

		System.out.println("---- Hotel Boa Viagem ----");
		for (int i = 0; i < 5; i++) {
			System.out.println("Nome do Cliente: ");
			arrayDados[i][0] = entrada.next();

			System.out.println("Tipo da acomodacao: ");
			arrayDados[i][1] = entrada.next();
			while (!(arrayDados[i][1].equalsIgnoreCase("S") || arrayDados[i][1].equalsIgnoreCase("D")
					|| arrayDados[i][1].equalsIgnoreCase("SL") || arrayDados[i][1].equalsIgnoreCase("SR"))) {

				System.out.println("Digite uma opcao válida: S/D/SL/SR");
				arrayDados[i][1] = entrada.next();
				
			}
			System.out.print("Numero do quarto: ");
			arrayNumero[i][0] = i+1;
			System.out.println(arrayNumero[i][0]);
			
			System.out.println("Quantidade de diárias: ");
			arrayNumero[i][1] = entrada.nextInt();
			System.out.println("-------------------------------------------------");
			System.out.println("");
		}
		System.out.println(" --- Consumo de Produtos por Hospedagem --- ");
		int consumoProd[][] =  consumoProduto(arrayNomeProduto);
		
		System.out.println("");
		System.out.println(" --- Consumo de Servicos por Hospedagem --- ");
		int consumoServ[][] = consumoServico(arrayNomeServico);
		
		double estadia[] = calculaEstadia();
		
		System.out.println("--- Relatório Gerencial ---");
		gerarRelatorioGerencial(consumoProd,consumoServ, arrayPrecoProduto,arrayPrecoServico, estadia);
		
	}
	
	static public int[][] consumoProduto(String[] arrayNomeProduto){
		int consumoProd[][] = new int[5][5];
		for(int i =0;i<5;i++) {
			System.out.println(" --- HOSPEDAGEM ("+(i+1)+")");
			for(int j=0;j<5;j++) {
				System.out.println("Iforme a quantidade consumida do produto ("+(arrayNomeProduto[j]+"): "));
				consumoProd[i][j] = entrada.nextInt();
				
			}
		}
		
		return consumoProd;
	}

	static public int[][] consumoServico(String[] arrayNomeServico){
		int consumoServ[][] = new int[5][5];
		for(int i =0;i<5;i++) {
			System.out.println(" --- HOSPEDAGEM ("+(i+1)+")");
			for(int j=0;j<5;j++) {
				System.out.println("Iforme a quantidade consumida do servico ("+(arrayNomeServico[j]+"): "));
				consumoServ[i][j] = entrada.nextInt();
				
			}
		}
		
		return consumoServ;
	}

	static public double[] calculaEstadia() {
		double estadia[] = new double[5];
		
		for(int i =0;i<5;i++) {
			if(arrayDados[i][1].equalsIgnoreCase("S")) {
				estadia[i] = arrayNumero[i][1] * 245;
			}else {
				if(arrayDados[i][1].equalsIgnoreCase("D")) {
					estadia[i] = arrayNumero[i][1] * 280;
				}else {
					if(arrayDados[i][1].equalsIgnoreCase("SL")) {
						estadia[i] = arrayNumero[i][1] * 310;
					}else {
						if(arrayDados[i][1].equalsIgnoreCase("SR")) {
							estadia[i] = arrayNumero[i][1] * 400;
						}
					}
				}
			}
		}
		
		return estadia;
	}

	static public void gerarRelatorioGerencial(int consumoProd[][],int consumoServ[][],double[] arrayPrecoProduto,double[] arrayPrecoServico,double[] estadia) {
		double totalProd[] = new double[5];
		double totalServ[] = new double[5];
		
		for(int i =0;i<5;i++) {
			for(int j=0;j<5;j++) {
			totalProd[i] = consumoProd[i][j] * arrayPrecoProduto[i];
			totalServ[i] = consumoServ[i][j] * arrayPrecoServico[i];
			}
		}
		
		double totalGeral[] = new double[5];
		System.out.println("--- RELATORIO ---");
		for(int i =0;i<5;i++) {
			totalGeral[i] = totalProd[i] + totalServ[i] + estadia[i];
			System.out.println("Número do quarto: "+arrayNumero[i][0]);
			System.out.println("Nome do Cliente: "+arrayDados[i][0]);
			System.out.println("Tipo de acomodacao: "+ arrayDados[i][1]);
			System.out.println("Quantidade de diarias: "+arrayNumero[i][1]);
			System.out.println("Valor total das diárias R$: "+estadia[i]);
			System.out.println("");
		}
		
		System.out.println("---- Relatório Gerencial -----");
		System.out.println("QUARTO |       CLIENTE |  TOTAL DIÁRIAS |  TOTAL SERVIÇO |  TOTAL PRODUTO | TOTAL GERAL");
		for(int i =0;i<5;i++) {
			System.out.print(arrayNumero[i][0]);
			System.out.print("\t\t"+arrayDados[i][0]);
			System.out.print("\t\t"+estadia[i]);
			System.out.print("\t\t"+numFormatado.format(totalServ[i]));
			System.out.print("\t\t"+numFormatado.format(totalProd[i]));
			System.out.print("\t\t"+numFormatado.format(totalGeral[i]));
			System.out.println("");
		}
		
	}
}
