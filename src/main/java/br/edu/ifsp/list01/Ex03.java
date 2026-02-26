package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Escrever um programa que, dado um ano válido qualquer, verifica se ele é bissexto ou não:

    São bissextos todos os anos múltiplos de 400, p. ex: 1600, 2000, 2400, 2800...
    São bissextos todos os múltiplos de 4 e não múltiplos de 100, p.ex: 1996, 2004, 2008, 2012, 2016…
    Não são bissextos os demais anos.
    Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 1600 | Saída = Ano bissexto
    Exemplo 2: Entrada = 1997 | Saída = Ano nao bissexto
    Exemplo 3: Entrada = 2000 | Saída = Ano bissexto
    Exemplo 4: Entrada = 2016 | Saída = Ano bissexto
    Exemplo 5: Entrada = 0 | Saída = Erro
*/
public class Ex03 {

    public static void main(String[] args) {

        Ex03 ex = new Ex03();
        Scanner scanner = new Scanner(System.in);

        int ano = scanner.nextInt();

        System.out.println(ex.compute(ano));

    }

    String compute(int ano) {
        if (ano <= 0) {
            return "Erro";
        }

        boolean bissexto = false;

        if (ano % 100 == 0) {
            bissexto = false;
        }

        if (ano % 4 == 0) {
            bissexto = true;
        }

        if (bissexto == true) {
            return "Ano bissexto";
        } else {
            return "Ano nao bissexto";
        }
    }
}
