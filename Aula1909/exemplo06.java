package Aula1909;

import java.util.Scanner;

public class exemplo06 {
	static Scanner entrada = new Scanner(System.in);
	//variavel global
	static String nome;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double media =0;
		System.out.println("Método principal");
		System.out.println("Digite o nome:");
		nome = entrada.next();
		
		//CHAMADA DA FUNÇÃO 
		media = calcula();
		
		//CHAMADA DO PROCEDIMENTO
		//PARAMETRO REAL
		analise(media);
		
	}
	
	
	//FUNÇÃO RETORNANDO A MÉDIA	
	public static double calcula() {
		//variáveis locais
		double n1=0,n2=0,media =0;
		System.out.println("Método função");
		System.out.println("Digite n1:");
		n1 = entrada.nextDouble();
		
		System.out.println("Digite n2:");
		n2 = entrada.nextDouble();
		
		media = (n1+n2)/2;
		return media;
	}
	
	
	//PROCEDIMENTO
	public static void analise(double media) {
		System.out.println("Método procedimento");
		if(media<3) {
			System.out.println(nome+" - DP - "+ media);
		}else {
			if(media<6) {
				System.out.println(nome+ " - Exame - "+media );
			}else {
				System.out.println(nome+" - Aprovado - "+media);
			}
		}
	}

}

