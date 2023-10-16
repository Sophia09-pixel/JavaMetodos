package Aula1909;

import java.util.Scanner;

public class metodos {
	//globais
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		//chamada do procedimento
		verificar();
		
	}//main
	
	
	//métodos
	//procedimento = void 
	public static void verificar() {
		int num =0;
		
		System.out.println("Digite o numero: ");
		num = entrada.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("Número Par");
		}else {
			System.out.println("Número Impar");
		}
	}

}
