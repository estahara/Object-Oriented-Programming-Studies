package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Você está de volta em seu hotel na Tailândia depois de um dia de mergulhos. O seu quarto tem duas lâmpadas, chamadas
    de A e B. No hotel há dois interruptores, que chamaremos de C1 e C2. Ao apertar C1, a lâmpada A acende se estiver
    apagada, e apaga se estiver acesa. Se apertar C2, cada uma das lâmpadas A e a B troca de estado: se estiver apagada,
    fica acesa e se estiver acesa apaga.

    Você chegou no hotel e encontrou as lâmpadas em um determinado estado, como foram deixadas por seu amigo. Vamos chamar
    o estado inicial da lâmpada A de IA e o estado inicial da lâmpada B de IB. Você gostaria de deixar as lâmpadas em uma
    certa configuração final, que chamaremos de FA e FB, respectivamente, apertando os interruptores a menor quantidade de
    vezes possível. Por exemplo, se as duas lâmpadas começam apagadas, e você quer que apenas a lâmpada A termine acesa,
    basta apertar o interruptor C1.

    Faça um programa que leia os estados iniciais IA e IB e os estados finais desejados FA e FB das duas lâmpadas.
    Os valores de IA, IB, FA e FB são lidos na mesma linha nessa ordem. Seus valores possíveis são 0, se a lâmpada estiver
    apagada e 1 caso contrário. Ao final, seu programa deverá imprimir o número mínimo de interruptores que devem ser
    apertados.

    Exemplos de entrada e saída:
    Entrada	| Saída
    0 0 1 1	| 1
    0 0 0 1	| 2
    Fonte: Adaptado de Olimpíada Brasileira de Informática (OBI)

    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int ia = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int ib = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int fa = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int fb = scanner.nextInt();

        Ex04 ex = new Ex04();
        int result = ex.compute(ia, ib, fa, fb);

        if (result == -1)
            System.out.println("Erro");
        else
            System.out.println(result);
    }

    int compute(int ia, int ib, int fa, int fb) {

        if ((ia != 0 && ia != 1) ||
            (ib != 0 && ib != 1) ||
            (fa != 0 && fa != 1) ||
            (fb != 0 && fb != 1))
            return -1;

        int min = Integer.MAX_VALUE;

        for (int c1 = 0; c1 <= 1; c1++) {
            for (int c2 = 0; c2 <= 1; c2++) {

                int a = ia;
                int b = ib;

                if (c1 % 2 == 1)
                    a = 1 - a;

                if (c2 % 2 == 1) {
                    a = 1 - a;
                    b = 1 - b;
                }

                if (a == fa && b == fb) {
                    int presses = c1 + c2;
                    if (presses < min)
                        min = presses;
                }
            }
        }

        if (min == Integer.MAX_VALUE)
            return -1;

        return min;
    }
}
