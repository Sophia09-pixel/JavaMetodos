package Aula1909;

import java.util.Scanner;

public class exemplo07 {

	//Global
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Local
		String nomes[] = new String[4];
		int idade[] = new int[4];
		
		for(int i=0;i<4;i++) {
			System.out.print("Digite o "+(i+1)+"° nome:");
			nomes[i] = entrada.next();
			System.out.print("Digite a "+(i+1)+"° idade:");
			idade[i] = entrada.nextInt();
		}
		//chamada
		verifica(nomes,idade);
		String requisito[] = analise(idade);
		for(int i =0;i<4;i++) {
			System.out.println(nomes[i]+" - "+idade[i]+" - "+requisito[i]);
		}
		
	}//main
	//método sem retorno = Procedimento
	public static void verifica(String nomes[],int idade[]) {
		System.out.println("");
		System.out.println("Lista de Alunos");
		for(int i=0;i<4;i++) {
			System.out.println(nomes[i]+" - "+idade[i]);
		}
	}
	//método com retorno = função
	
	public static String[] analise(int idade[]) {
		String requisito[] = new String[4];
		System.out.println("");
		System.out.println("Lista de Análise de requisito");
		for(int i =0;i<4;i++) {
			if(idade[i]>=18) {
				requisito[i] = "Permitido";
			}else {
				requisito[i] = "Não Permitido";
			}
		}
		
		return requisito;
	}

}
