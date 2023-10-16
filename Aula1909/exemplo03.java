package Aula1909;

import java.util.Scanner;

public class exemplo03 {

	// variaveis globais 
	static Scanner entrada = new Scanner(System.in);
	static String nome;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//variaveis locais
		int tempoEmp=0;
		double salario=0;
		
		System.out.println("Digite o nome: ");
		nome = entrada.next();
		
		System.out.println("Digite o tempo de empresa: ");
		tempoEmp = entrada.nextInt();
		
		System.out.println("Digite o salário: ");
		salario = entrada.nextDouble();
		
		//parametros Reais
		verifica(tempoEmp,salario);
	}
	
	//procedimento
	//parametros formais
	public static void verifica(int tempoEmp,double salario) {
		
		if(tempoEmp>10&&salario<5000) {
			System.out.println(nome+" - Reajuste Aprovado");
		}else {
			System.out.println(nome+" - Reprovado Reajuste");
		}
		
	}

}
