package br.edu.ifsp.list02;

/*
    Faça um programa que leia dados inteiros da temperatura diária durante uma semana,
    armazenando em um vetor. Na sequência, escreva quantos dias dessa semana a temperatura
    esteve acima da média. As sete temperaturas devem ser lidas na mesma linha, separada
    por espaço.

    Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 2 2 2 2 2 2 3 | Saída = 1
    Exemplo 2: Entrada = 21 10 13 34 30 21 34 | Saída = 3
    Exemplo 3: Entrada = 2 2 2 2 2 2 1| Saída = 6
    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
*/

import java.util.Scanner;

public class Ex01 {

    public static final int DAYS_IN_WEEK = 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] temperatures = new int[DAYS_IN_WEEK];

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            temperatures[i] = scanner.nextInt();
        }

        Ex01 ex01 = new Ex01();
        String result = ex01.compute(temperatures);
        System.out.println(result);
    }

    String compute(int[] temperatures) {

        if (temperatures == null || temperatures.length != DAYS_IN_WEEK) {
            return "Erro";
        }

        int sum = 0;
        int aboveAverage = 0;

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            sum += temperatures[i];
        }

        double mean = (double) sum / DAYS_IN_WEEK;

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            if (temperatures[i] > mean) {
                aboveAverage++;
            }
        }

        return String.format("%d", aboveAverage);
    }
}
