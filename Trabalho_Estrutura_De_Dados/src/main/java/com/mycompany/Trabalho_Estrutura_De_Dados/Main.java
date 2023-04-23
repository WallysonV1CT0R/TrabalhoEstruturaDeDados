package com.mycompany.Trabalho_Estrutura_De_Dados;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String[] opcoes = {"Bolha", "Seleção", "Inserção"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione o tipo de ordenação:", "Ordenação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        int[] numeros;
        if (JOptionPane.showConfirmDialog(null, "Deseja inserir um vetor de números inteiros?") == JOptionPane.YES_OPTION) {
            int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor:"));
            numeros = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i + 1) + "º número do vetor:"));
            }
        } else {
            // vetor padrão
            numeros = new int[]{12,21,34,64,2,6,31,76};
        }
        
        long tempoInicial = System.currentTimeMillis();

        switch (opcaoSelecionada) {
            case 0: // Bolha
                bolha(numeros);
                break;
            case 1: // Seleção
                selecao(numeros);
                break;
            case 2: // Inserção
                insercao(numeros);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
        }
        
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        
        // Imprime o array ordenado
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
            
        }
        // Imprime o tempo de execução
        System.out.println("\nTempo de execução: " + tempoTotal + "ms");
    }

    public static void bolha(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    
    } 

    public static void selecao(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    
    }

    public static void insercao(int[] vetor) {
        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        } 
        
   
    }
}
