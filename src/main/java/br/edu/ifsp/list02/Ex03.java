package br.edu.ifsp.list02;

import java.util.scanner;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {

    public static final int MAX_SIZE = 10;
    public static final int INITIAL_SIZE = 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstFive = new int[INITIAL_SIZE];
        int[] otherInts = new int[MAX_SIZE];

       
        for (int i = 0; i < INITIAL_SIZE; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Erro");
                return;
            }
            firstFive[i] = scanner.nextInt();
        }

        Ex03 ex = new Ex03();

        for (int i = 0; i < 5; i++) {
            if (!scanner.hasNextInt()) break;
            int next = scanner.nextInt();
            ex.compute(firstFive, next);
        }
    }

    int currentSize = INITIAL_SIZE;

    String compute(int[] vetor, int next) {

        if (vetor == null || vetor.length != MAX_SIZE) {
            return "Erro";
        }

        boolean exists = false;
        int position = -1;

        for (int i = 0; i < currentSize; i++) {
            if (vetor[i] == next) {
                exists = true;
                position = i;
                break;
            }
        }

        if (exists) {
            for (int i = position; i < currentSize - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            vetor[currentSize - 1] = 0;
            currentSize--;
        } else {
            if (currentSize >= MAX_SIZE) {
                return "Erro";
            }
            vetor[currentSize] = next;
            currentSize++;
        }

        String output = "";
        for (int i = 0; i < currentSize; i++) {
            output += vetor[i];
            if (i < currentSize - 1) output += ", ";
        }

        System.out.println(output);
        return output;
    }
}
