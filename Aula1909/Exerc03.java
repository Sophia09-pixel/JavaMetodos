package Aula1909;

import java.util.Scanner;

public class Exerc03 {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nomes[] = new String[4]; 
		double salario[] = new double[4];
		int tempo[] =  new int[4];
		
		for(int i =0;i<4;i++) {
			System.out.println("Digite o seu nome: ");
			nomes[i] = entrada.next();
			System.out.println("Digite o seu salário: ");
			salario[i] = entrada.nextDouble();
			System.out.println("Digite o seu tempo de empresa: ");
			tempo[i] = entrada.nextInt();
		}
		String aumento[] = calcula(salario,tempo);
		resultado(nomes,salario,tempo,aumento);
		
	}
	
	public static String[] calcula(double salario[],int tempo[]) {
		String aumento[] = new String[4];
		
		for(int i =0;i<4;i++) {
			if(salario[i]<700 || tempo[i] >3) {
				aumento[i] = "Aumento Aprovado";
			}else {
				aumento[i] = "Aumento Reprovado";
			}
		}
		
		return aumento;
	}
	
	public static void resultado(String nomes[],double salario[],int tempo[],String[] aumento) {
		System.out.println("");
		System.out.println("Relatório");
		for(int i =0;i<4;i++) {
			System.out.println("");
			System.out.println(nomes[i]+" - salario: "+salario[i]+" - tempo de empresa: "+tempo[i]+" - situação de aumento: "+aumento[i]);
		}
	}

}
