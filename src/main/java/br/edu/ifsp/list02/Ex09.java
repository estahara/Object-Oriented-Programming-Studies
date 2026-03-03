package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Uma loja especializada em vendas pela internet está desenvolvendo drones para entrega de caixas com as compras dos
    clientes. Cada caixa tem a forma de um paralelepípedo reto retângulo (ou seja, no formato de um tijolo).

    O drone entregará uma caixa de cada vez, e colocará a caixa diretamente dentro da casa do cliente, por meio de uma
    janela. Todas as janelas dos clientes têm o formato retangular e estão sempre totalmente abertas. O drone tem um
    aplicativo de visão computacional que calcula exatamente as dimensões H e L da janela. O drone consegue colocar
    a caixa através da janela somente quando uma das faces da caixa está paralela à janela, mas consegue virar e
    rotacionar a caixa antes de passá-la pela janela.

    Faça um programa que lê cinco números inteiros, cada um em uma linha. As três primeiras linhas representam os
    valores A, B e C, indicando as três dimensões da caixa, em centímetros. As duas últimas linhas representam
    os valores H e L, indicando a altura e a largura da janela, em centímetros. Seu programa deve escrever uma
    única linha, contendo apenas a letra "S" se a caixa passa pela janela e apenas a letra "N" caso contrário.

    ### Exemplos de entrada e saída:

    | Entrada                              | Saída  |
    | -------                              | ------ |
    | 30                                   | S      |
    | 50                                   |        |
    | 80                                   |        |
    | 80                                   |        |
    | 60                                   |        |
    | -------                              | ------ |
    | 75                                   | N      |
    | 100                                  |        |
    | 50                                   |        |
    | 100                                  |        |
    | 30                                   |        |
    | -------                              | ------ |
    | 20                                   | S      |
    | 22                                   |        |
    | 5                                    |        |
    | 20                                   |        |
    | 10                                   |        |
    | -------                              | ------ |

    Fonte: Adaptado de Olimpíada Brasileira de Informática (OBI)
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("N");
            return;
        }
        int a = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("N");
            return;
        }
        int b = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("N");
            return;
        }
        int c = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("N");
            return;
        }
        int h = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("N");
            return;
        }
        int l = scanner.nextInt();

        Ex09 ex = new Ex09();
        System.out.println(ex.compute(a, b, c, h, l));
    }

    String compute(int a, int b, int c, int h, int l) {

        if (a <= 0 || b <= 0 || c <= 0 || h <= 0 || l <= 0)
            return "N";

        int[][] faces = {
            {a, b},
            {a, c},
            {b, c}
        };

        for (int i = 0; i < 3; i++) {

            int x = faces[i][0];
            int y = faces[i][1];

            if ((x <= h && y <= l) || (x <= l && y <= h))
                return "S";
        }

        return "N";
    }
}
