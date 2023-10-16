package Aula1909;

import java.util.Scanner;

public class exemplo05 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double nota1 = 0, nota2 = 0;
		double media = 0;
		System.out.println("Digite nota 1: ");
		nota1 = entrada.nextDouble();
		System.out.println("Digite nota 2: ");
		nota2 = entrada.nextDouble();

		// chamada da função
		// precisa guardar a informação de retorno
		media = calcular(nota1, nota2);
		System.out.println("Média: " + media);

	}// main

	public static double calcular(double nota1, double nota2) {
		double media = 0;
		media = (nota1 + nota2) / 2;
		return media;

	}

}
