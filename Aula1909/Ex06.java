package Aula1909;

import java.util.Scanner;

public class Ex06 {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--- PESQUISA HABITANTES ---");
		char sexo[] = preecheSexo();
		System.out.println("");
		char olhos[] = preencheOlhos();
		System.out.println("");
		char cabelo[] = preencheCabelo();
		System.out.println("");
		int idade[] = preencherIdade();
		
		//chamada análise
		double media=mediaIdades(olhos,cabelo,idade);
		System.out.println("Média das Idades das pessoas com olhos castanhos e olhos pretos: "+media);
		
		int maior= maiorIdade(idade);
		System.out.println("Maior idade entre os habitantes: "+maior);
		
		int qtd=qtdIndividuos(sexo,idade,olhos,cabelo);
		System.out.println("Qtd de individuos do sexo F, idade entre 18 e 35, olhos azuis e cabelo Louro:"+qtd);
	
	}
	//métodos de carregamento
	public static char[] preecheSexo() {
		char sexo[] = new char[5];
		for(int i =0;i<5;i++) {
			System.out.println("Digite o sexo da "+(i+1)+"° pessoa: ");
			sexo[i] = entrada.next().toUpperCase().charAt(0);
			while(!(sexo[i]=='F'||sexo[i]=='M')) {
				System.out.println("Digite uma opção válida: (F/M)");
				sexo[i] = entrada.next().toUpperCase().charAt(0);
			}
			
		}
		return sexo;
	}

	public static char[] preencheOlhos() {

		char olhos[] = new char[5];
		for(int i =0;i<5;i++) {
			System.out.println("Digite a cor dos olhos da "+(i+1)+"° pessoa: ");
			olhos[i] =entrada.next().toUpperCase().charAt(0);
			while(!(olhos[i]=='A'||olhos[i]=='C')) {
				System.out.println("Digite uma opção válida: (A/C)");
				olhos[i] = entrada.next().toUpperCase().charAt(0);
			}
		}
		
		return olhos;
	}

	public static char[] preencheCabelo() {
		char cabelo[] = new char[5];
		for(int i =0;i<5;i++) {
			System.out.println("Digite a cor do cabelo da "+(i+1)+"° pessoa: ");
			cabelo[i] =entrada.next().toUpperCase().charAt(0);
			while(!(cabelo[i]=='L'||cabelo[i]=='P'||cabelo[i]=='C')) {
				System.out.println("Digite uma opção válida: (L/P/C)");
				cabelo[i] = entrada.next().toUpperCase().charAt(0);
			}
		}
		return cabelo;
	}

	public static int[] preencherIdade() {
		int idade[] = new int[5];
		for(int i=0;i<5;i++) {
			System.out.println("Digite a idade da "+(i+1)+"° pessoa: ");
			idade[i] = entrada.nextInt();
		}
		
		return idade;
	}

	//métodos análise
	public static double mediaIdades(char []olhos,char []cabelo,int[] idade) {
		double media=0,somaIdade=0;
		int cont=0;
		
		for(int i =0;i<5;i++) {
			if(olhos[i] =='C'&& cabelo[i] == 'P') {
				somaIdade += idade[i];
				cont++;
			}
		}
		media = somaIdade/cont;
		return media;
	}

	public static int maiorIdade(int[]idade) {
		int maior=0;
		for(int i =0;i<5;i++) {
			if(idade[i]>maior) {
				maior=idade[i];
			}
		}
		return maior;
	}

	public static int qtdIndividuos(char sexo[],int idade[],char olhos[],char cabelo[]) {
		int qtd=0;
		for(int i =0;i<5;i++) {
		if(sexo[i]=='F'&& olhos[i]=='A'&&cabelo[i]=='L'&&(idade[i]>18&&idade[i]<35)) {
			qtd++;
			
			}
		}
		
		return qtd;
	}
	
}
