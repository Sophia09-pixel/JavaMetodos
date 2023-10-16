package Aula1909;

import java.util.Scanner;

public class exemplo02 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao=0;
		
		while(opcao!=5) {
			System.out.println("[1] - Adição");
			System.out.println("[2] - Subtração");
			System.out.println("[3] - Multiplicação");
			System.out.println("[4] - Divisão");
			System.out.println("[5] - Sair");
			
			System.out.println("Escolha uma opção: ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1: adicao();
			break;
			case 2: subtracao();
			break;
			case 3: multiplicacao();
			break;
			case 4: divisao();
			break;
			case 5: System.exit(0);
			break;
			default:
				System.out.println("Opção Inválida - Tente Novamente");
			}
		}
		
	}//fecha main
	//Procedimentos
	public static void adicao() {
		int n1=0,n2=0,r=0;
		System.out.println("OPERAÇÃO ADIÇÃO");
		System.out.println("Digite o 1° número:");
		n1 = entrada.nextInt();
		System.out.println("Digite o 2° número:");
		n2 = entrada.nextInt();
		r = n1+n2;
		System.out.println("Resultado: "+r);
	}
	
	public static void multiplicacao() {
		int n1=0,n2=0,r=0;
		System.out.println("OPERAÇÃO MULTIPLICAÇÃO");
		System.out.println("Digite o 1° número:");
		n1 = entrada.nextInt();
		System.out.println("Digite o 2° número:");
		n2 = entrada.nextInt();
		r = n1*n2;
		System.out.println("Resultado: "+r);
	}
	
	public static void subtracao() {
		int n1=0,n2=0,r=0;
		System.out.println("OPERAÇÃO SUBTRÇÃO");
		System.out.println("Digite o 1° número:");
		n1 = entrada.nextInt();
		System.out.println("Digite o 2° número:");
		n2 = entrada.nextInt();
		r = n1-n2;
		System.out.println("Resultado: "+r);
	}
	
	public static void divisao() {
		int n1=0,n2=0,r=0;
		System.out.println("OPERAÇÃO DIVISÃO");
		System.out.println("Digite o 1° número:");
		n1 = entrada.nextInt();
		System.out.println("Digite o 2° número:");
		n2 = entrada.nextInt();
		r = n1/n2;
		System.out.println("Resultado: "+r);
	}

}
