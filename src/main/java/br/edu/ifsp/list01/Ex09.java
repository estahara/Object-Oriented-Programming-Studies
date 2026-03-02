package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        Ex09 ex = new Ex09();
        Scanner scanner = new Scanner(System.in);

        int[] idades = new int[100];

        int idade = scanner.nextInt();
        int contador = 0;

        if(idade < 0) {
            System.out.println("Erro");
        } else {
            while (idade >= 0) {
                idades[contador] = idade;
                contador++;
                idade = scanner.nextInt();
            }

            System.out.println(ex.compute(idades, contador));

        }

    }

    String compute(int[] input, int len) {
        double media = 0;
        int maiorIdade = 0;
        int qtdIdosos = 0;

        for (int i = 0; i < len; i++) {
            media += input[i];

            if (input[i] >= 18)
                maiorIdade++;

            if (input[i] > 75)
                qtdIdosos++;
        }


        media = media / len;
        double porcentagemIdosos = ((double) qtdIdosos / len) * 100.00;

        return String.format("%.2f %d %.2f%%", media, maiorIdade, porcentagemIdosos);
    }
}
