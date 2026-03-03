package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Faça um programa que leia um valor inteiro N. Após isso, leia dois vetores A e B de tamanho N. Em seguida, o programa
    deve criar um vetor C com os elementos de A e B intercalados.

    Exemplos de entrada e saída:

    | Entrada                 | Saída                         |
    | -------                 | ------                        |
    | 6                       | 5 10 6 20 3 30 8 40 2 50 0 60 |
    | 5 6 3 8 2 0             |                               |
    | 10 20 30 40 50 60       |                               |
      ---
    | 3                       | 1 1 2 1 3 1                   |
    | 1 2 3                   |                               |
    | 1 1 1                   |                               |

    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Erro");
            return;
        }

        int[] arrayA = new int[n];
        int[] arrayB = new int[n];

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Erro");
                return;
            }
            arrayA[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Erro");
                return;
            }
            arrayB[i] = scanner.nextInt();
        }

        Ex06 ex = new Ex06();
        String result = ex.compute(arrayA, arrayB);

        if (result == null)
            System.out.println("Erro");
        else
            System.out.println(result);
    }

    String compute(int[] arrayA, int[] arrayB) {

        if (arrayA == null || arrayB == null)
            return null;

        if (arrayA.length != arrayB.length)
            return null;

        int n = arrayA.length;
        int[] arrayC = new int[n * 2];

        int index = 0;

        for (int i = 0; i < n; i++) {
            arrayC[index] = arrayA[i];
            index++;
            arrayC[index] = arrayB[i];
            index++;
        }

        String output = "";

        for (int i = 0; i < arrayC.length; i++) {
            output += arrayC[i];
            if (i < arrayC.length - 1)
                output += " ";
        }

        return output;
    }
}
