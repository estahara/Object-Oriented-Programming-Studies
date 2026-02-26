package br.edu.ifsp.list01;

/*
    Sejam a, b e c os três lados de um triângulo. Elabore um algoritmo que verifica se o triângulo é:

    Escaleno (todos os lados diferentes)
    Isósceles (possui dois lados iguais)
    Equilátero (todos os lados iguais)
    Não forma triângulo (a soma de dois lados deve ser maior que o terceiro lado)
    Os três números devem ser inteiros positivos e lidos na mesma linha (Ex: 3 4 5) Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 2 3 2 | Saída = Isosceles
    Exemplo 2: Entrada = 2 2 2 | Saída = Equilatero
    Exemplo 3: Entrada = 1 2 4 | Saída = Nao forma triangulo
    Exemplo 4: Entrada = -1 2 4 | Saída = Erro
    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
*/

import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        Ex02 ex = new Ex02();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os tres valores a,b e c, respectivamente:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(ex.compute(a,b,c));

    }

    String compute(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return "Erro";
        } else {
            if ((a + b < c) || (b + c < a)) {
                return "Nao forma triangulo";
            } else  if ((a == b && a != c) || (a == c && a != b)) {
                return "Isosceles";
            } else if (a == b && a == c) {
                return "Equilatero";
            } else if (a != b && a != c && c != b) {
                return "Escaleno";
            } else {
                return "Erro";
            }
        }


        //put your logic here

    }
}
