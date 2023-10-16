package Aula1909;

import java.util.Scanner;

public class Exerc02 {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cod =0;
		double carga=0;
		int estado=0;
		
		System.out.println("Digite o código do caminhão:");
		cod = entrada.nextInt();
		
		System.out.println("Digite a carga do caminhão:");
		carga = entrada.nextDouble();
		
		System.out.println("Digite o codigo do Estado");
		estado = entrada.nextInt();
		
		
		double valorCarga=calcula(cod,carga);
		double imp = imposto(estado,valorCarga);
		
		
		System.out.println("Valor Total: "+imp+" preço da carga: "+valorCarga+"");
		
	}
	
	public static double calcula(int cod,double carga) {
		double conversao =0,valorCarga=0;
		if(cod > 0 && cod <11) {
			conversao = carga * 1000;
			valorCarga = conversao * 120;
			
		}else {
			if(cod >=11 && cod <=20) {
				conversao = carga * 1000;
				valorCarga = conversao * 200;
			}else {
				if(cod >=21 && cod <=30) {
					conversao = carga * 1000;
					valorCarga = conversao * 280;
				}
			}
		}
		
		return valorCarga;
	
	}
	
	public static double imposto(int estado,double valorCarga) {
		double imp=0;
		if(estado==1) {
			imp = valorCarga * 1.25;
		}else {
			if(estado ==2) {
				imp = valorCarga * 1.20;
			}else {
				if(estado ==3) {
					imp = valorCarga * 1.15;
				}else {
					if(estado ==4) {
						imp = valorCarga;
					}
				}
			}
		}
		
		return imp;
	}
	
	

}
