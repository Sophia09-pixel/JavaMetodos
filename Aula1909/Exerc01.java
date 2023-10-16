package Aula1909;

import java.util.Scanner;

public class Exerc01 {

	static String nome;
	static int acomodacao=0,diaria=0,dias=0;
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double estadia=0;
		System.out.println("Digite o seu nome: ");
		nome = entrada.next();
		
		System.out.println("Digite o tipo de acomodação: ");
		acomodacao = entrada.nextInt();
		while(!(acomodacao==1||acomodacao==2||acomodacao==3)) {
			System.out.println("Digite uma opção válida: 1/2/3");
			acomodacao = entrada.nextInt();
		}
		
		
		System.out.println("Digite a quantidade de dias que irá se ospedar: ");
		dias = entrada.nextInt();
		//chama a função calculo
		estadia = calculo();
		
		System.out.println("Valor da estadia: "+estadia);
		System.out.println("");
		pagamento(estadia);
		
	}
	
	public static double calculo() {
		double estadia=0;
		if(acomodacao==1) {
			diaria =380;
		}else {
			if(acomodacao==2) {
				diaria = 450;
			}else {
				if(acomodacao==3){
					diaria=500;
				}
			}
		}
		
		estadia = diaria*dias;
		return estadia;
	}
	
	public static void pagamento(double estadia) {
		char pagamento;
		double desconto = 0, valorFinal = 0;
		System.out.println("Digite a forma de pagamento: ");
		pagamento = entrada.next().toUpperCase().charAt(0);
		while(!(pagamento=='V'||pagamento=='P')) {
			System.out.println("Digite uma opção válida V/P");
			pagamento = entrada.next().toUpperCase().charAt(0);
		}
		
		if(pagamento == 'V') {
			valorFinal = estadia *0.9;
		}
		
		System.out.println("Valor Final: "+valorFinal);
		
	}

}
