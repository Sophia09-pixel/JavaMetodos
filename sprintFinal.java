package pastinha;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class sprintFinal {
	
	 public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);

	        System.out.println("==== ROBOCUP ====");
	        System.out.print("Digite a quantidade de equipes participantes: ");
	        int numEquipes = entrada.nextInt();
	        while(numEquipes<3) {
	        	System.out.println("Digite no mínimo 3 equipes");
	        	numEquipes = entrada.nextInt(); 
	        }

	        int[] equipes = new int[numEquipes];
	        int[] pontosEquipes = new int[numEquipes];
	        int[] notaDesignEquipes = new int[numEquipes];

	        for (int i = 0; i < numEquipes; i++) {
	            System.out.print("Digite o número da " + (i + 1) + "ª Equipe: ");
	            equipes[i] = entrada.nextInt();
	            while(equipes[i]<11||equipes[i]>99) {
	            	System.out.println("Digite um número válido entre 11 e 99!");
	            	equipes[i] = entrada.nextInt();
	            }
	        }

	        System.out.println("\n==== FASE DE GRUPOS ====");
	        gerarCombates(numEquipes, equipes, pontosEquipes, notaDesignEquipes);

	        System.out.println("\n==== PONTUAÇÕES ====");
	        for (int i = 0; i < numEquipes; i++) {
	            System.out.println("Pontuação da Equipe " + equipes[i] + ": " + pontosEquipes[i]);
	        }

	        System.out.println("\n==== 3 MELHORES EQUIPES ====");
	        int[] melhoresEquipes = determinarMelhoresEquipes(pontosEquipes, equipes);
	        for (int i = 0; i < Math.min(3, melhoresEquipes.length); i++) {
	            System.out.println("Equipe " + equipes[melhoresEquipes[i]] +
	                    " - Pontuação: " + pontosEquipes[melhoresEquipes[i]]);
	        }
	        System.out.println("===========================");

	        System.out.println("\nFase final entre as 3 melhores equipes:");
	        System.out.println("");
	        realizarFaseFinal(melhoresEquipes, pontosEquipes, notaDesignEquipes, equipes, entrada);

	        int equipeVencedora = determinarEquipeVencedora(pontosEquipes);
	        System.out.println("A equipe vencedora é: Equipe " + equipes[equipeVencedora] +
	                " - Pontuação: " + pontosEquipes[equipeVencedora]);
	    }

    public static int gerarPontuacaoAleatoria() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static void gerarCombates(int numEquipes, int[] equipes, int[] pontosEquipes, int[] notaDesignEquipes) {
        Random random = new Random();

        for (int i = 0; i < numEquipes; i++) {
            for (int j = i + 1; j < numEquipes; j++) {
                int pontuacaoEquipeA = gerarPontuacaoAleatoria();
                int pontuacaoEquipeB = gerarPontuacaoAleatoria();

                System.out.println("Combate: Equipe " + equipes[i] + " x Equipe " + equipes[j]);
                System.out.println("Pontuação Equipe " + equipes[i] + ": " + pontuacaoEquipeA);
                System.out.println("Pontuação Equipe " + equipes[j] + ": " + pontuacaoEquipeB);

                if (pontuacaoEquipeA > pontuacaoEquipeB) {
                    System.out.println("Equipe " + equipes[i] + " venceu o combate!\n");
                    pontosEquipes[i] += 5;
                } else if (pontuacaoEquipeB > pontuacaoEquipeA) {
                    System.out.println("Equipe " + equipes[j] + " venceu o combate!\n");
                    pontosEquipes[j] += 5;
                } else {
                    System.out.println("Houve empate! Utilizando a nota de design para desempate.");
                    int notaDesignA = gerarPontuacaoAleatoria();
                    int notaDesignB = gerarPontuacaoAleatoria();
                    notaDesignEquipes[i] = notaDesignA;
                    notaDesignEquipes[j] = notaDesignB;

                    if (notaDesignA > notaDesignB) {
                        System.out.println("Equipe " + equipes[i] + " venceu o desempate por nota de design!\n");
                        pontosEquipes[i] += 3;
                    } else if (notaDesignB > notaDesignA) {
                        System.out.println("Equipe " + equipes[j] + " venceu o desempate por nota de design!\n");
                        pontosEquipes[j] += 3;
                    } else {
                        System.out.println("Empate no desempate! Ambas as equipes são consideradas vencedoras.\n");
                        pontosEquipes[i] += 3;
                        pontosEquipes[j] += 3;
                    }
                }
                System.out.println("===========================");
            }
        }
    }

    public static int[] determinarMelhoresEquipes(int[] pontosEquipes, int[] equipes) {
        int[] copiaPontosEquipes = Arrays.copyOf(pontosEquipes, pontosEquipes.length);

  
        Integer[] indices = new Integer[copiaPontosEquipes.length];
        for (int i = 0; i < copiaPontosEquipes.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(copiaPontosEquipes[b], copiaPontosEquipes[a]));

      
        int[] tresMelhores = new int[Math.min(3, copiaPontosEquipes.length)];
        for (int i = 0; i < tresMelhores.length; i++) {
            tresMelhores[i] = indices[i];
        }

        return tresMelhores;
    }
    
    private static int encontrarIndiceOriginal(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1; 
    }

    public static void realizarFaseFinal(int[] melhoresEquipes, int[] pontosEquipes, int[] notaDesignEquipes, int[] equipes, Scanner scanner) {
        int numMelhores = Math.min(3, melhoresEquipes.length);

        for (int i = 0; i < numMelhores; i++) {
            int equipeA = melhoresEquipes[i];

            for (int j = i + 1; j < numMelhores; j++) {
                int equipeB = melhoresEquipes[j];
                int pontuacaoAtualA = gerarPontuacaoAleatoria();
                int pontuacaoAtualB = gerarPontuacaoAleatoria();

                System.out.println("Combate: Equipe " + equipes[equipeA] + " x Equipe " + equipes[equipeB]);
                System.out.println("Pontuação Equipe " + equipes[equipeA] + ": " + pontuacaoAtualA);
                System.out.println("Pontuação Equipe " + equipes[equipeB] + ": " + pontuacaoAtualB);
                System.out.println("===========================");

                if (pontuacaoAtualA > pontuacaoAtualB) {
                    pontosEquipes[equipeA] += 2;
                    System.out.println("Equipe " + equipes[equipeA] + " venceu o combate!\n");
                } else if (pontuacaoAtualA < pontuacaoAtualB) {
                    pontosEquipes[equipeB] += 2;
                    System.out.println("Equipe " + equipes[equipeB] + " venceu o combate!\n");
                } else {
                    pontosEquipes[equipeA] += 1;
                    pontosEquipes[equipeB] += 1;
                    System.out.println("Houve empate no combate da fase final!\n");
                }
            }
        }
    }

    public static int determinarEquipeVencedora(int[] pontosEquipes) {
        int equipeVencedora = 0;
        int melhorPontuacao = pontosEquipes[0];

        for (int i = 1; i < pontosEquipes.length; i++) {
            if (pontosEquipes[i] > melhorPontuacao) {
                melhorPontuacao = pontosEquipes[i];
                equipeVencedora = i;
            }
        }

        return equipeVencedora;
    }
}