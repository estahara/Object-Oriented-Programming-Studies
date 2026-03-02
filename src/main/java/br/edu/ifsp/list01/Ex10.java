package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Você está na Austrália treinando cangurus para se locomoverem em linha reta. Você quer saber se dois cangurus
    estarão na mesma posição em um determinado tempo, dado a posição inicial de cada canguru e qual a distância que
    eles saltam. Como você sabe programar muito bem, você decidiu fazer um programa para isso. Seu programa deve ler:
     - A posição inicial X1 e a distância do pulo V1 do primeiro canguru.
     - A posição inicial X2 e a distância do pulo V2 do segundo canguru.

    Após isso, seu programa deve imprimir SIM se os dois cangurus se encontrarão no mesmo ponto e NAO caso eles
    nunca se encontrem.

    Por exemplo, o primeiro canguru começa em X1 = 2 e tem uma distância do pulo de V1 = 1. O segundo canguru começa
    em X2 = 1 e tem uma distância de pulo de V2 = 2. Após um pulo ambos estarão no ponto *3*, portanto a respota é SIM.

    ### Exemplos de entrada e saída:

    | Entrada    | Saída  |
    | -------    | ------ |
    | 0  3  4  2 | SIM    |
    | 0  2  5  3 | NAO    |


    Fonte: Adaptado de https://www.hackerrank.com/challenges/kangaroo/problem

    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
*/
public class Ex10 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui

        Ex10 ex = new Ex10();
        Scanner scanner = new Scanner(System.in);

        int X1 = scanner.nextInt();
        int V1 = scanner.nextInt();
        int X2 = scanner.nextInt();
        int V2 = scanner.nextInt();

        System.out.println(ex.compute(X1,V1,X2,V2));

    }

    String compute(int x1, int v1, int x2, int v2) {
        if (v1 == v2) {
            if (x1 == x2)
                return "SIM";
            else
                return "NAO";
        }

        int diferencaPos = x2 - x1;
        int diferencaVel = v1 - v2;

        if (diferencaPos % diferencaVel == 0 &&
                diferencaPos / diferencaVel >= 0) {
            return "SIM";
        }

        return "NAO";

    }
}
