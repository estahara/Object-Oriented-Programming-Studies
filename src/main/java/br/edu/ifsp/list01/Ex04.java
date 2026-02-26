package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Osmar adora chocolates e vai para a loja com N dinheiro no bolso. O preço de cada chocolate é C.
    A loja oferece um desconto: para cada M embalagens que ele dá para a loja, ele ganha um chocolate grátis.
    Quantos chocolates Osmar consegue comer? Por exemplo:

    Para N=10, C=2, M=5, ele pode comprar 5 chocolates por $10 e trocar as 5 embalagens por mais 1 chocolate,
    fazendo com que o número total de chocolates que ele pode comer seja 6.
    Faça um programa que leia inteiros N, C e M e imprima a quantidade de chocolates que Osmar pode comer.
    C e M são inteiros positivos.

    Entrada	Saída
    10      6
    2
    5
 */
public class Ex04 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        Ex04 ex = new Ex04();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a entrada dinheiroTotal, preçoChocolate e embalagensNecessarias, respectivamente:");
        int N = scanner.nextInt();
        int C = scanner.nextInt();
        int M = scanner.nextInt();

        if (ex.compute(N,C,M) == -1) {
            System.out.println("Erro");
        } else {
            System.out.println(ex.compute(N,C,M));
        }
    }

    int compute(int dinheiro, int preco, int embalagens) {

        if (dinheiro <= 0 || preco <= 0 || embalagens <= 0) {
            return -1;
        }

        int totalComido = 0;

        if (dinheiro < preco) {
            return totalComido;
        } else {
            totalComido = dinheiro / preco;
            if (totalComido >= embalagens) {
                totalComido += totalComido / embalagens;
            } else {
                return totalComido;
            }
        }

        return totalComido;
    }
}
