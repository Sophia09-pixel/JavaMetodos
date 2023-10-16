package Aula1909;

import java.util.Scanner;

public class Aula0310 {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double vetorA [] = carregar();
		ordernar(vetorA);
		
		for(int i=0;i<5;i++) {
			System.out.println(vetorA[i]);
		}
	}
	public static double[] carregar() {
		double vetorA [] = new double[5];
		
		for(int i =0;i<5;i++) {
			System.out.println("Digite o "+(i+1)+"° número: ");
			vetorA[i] = entrada.nextDouble();
		}
		
		return vetorA;
	}

	public static double[] ordernar(double [] vetorA) {
		double aux=0;
		
		for(int i=0;i<5;i++) {//varre
			for(int j=0;j<4;j++) {//compara
				if(vetorA[j]>vetorA[j+1]) {
					aux = vetorA[j];
					vetorA[j] = vetorA[j+1];
					vetorA[j+1] = aux;
					
				}
			}
		}
		
		return vetorA;
	}
}
