import java.util.Scanner;

public class ex05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ex05 ex = new ex05();

        int N = scanner.nextInt();
        int C = scanner.nextInt();

        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        int lucro = ex.compute(N, C, prices);
        System.out.println(lucro);
    }

    int compute(int N, int C, int[] prices) {
        int lucro = 0;
        int precoCompra = -1;

        for (int i = 0; i < N; i++) {
            int precoAtual = prices[i];

            if (precoCompra == -1) {
                if (i < N - 1 && prices[i + 1] > precoAtual + C) {
                    precoCompra = precoAtual + C;
                }
            } else {
                if (precoAtual >= precoCompra) {
                    lucro += precoAtual - precoCompra;
                    precoCompra = -1;
                }
            }
        }
        return lucro;
    }
}