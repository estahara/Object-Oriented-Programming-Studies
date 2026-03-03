import java.util.Scanner;

public class ex03 {

    public static void main(String[] args) {
        ex03 ex = new ex03();
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int N = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int M = scanner.nextInt();

        if (N < 1 || N > 100 || M < 1 || M > 100) {
            System.out.println("Erro");
            return;
        }

        int[][] campo = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Erro");
                    return;
                }
                int p = scanner.nextInt();
                if (p < 0 || p > 500) {
                    System.out.println("Erro");
                    return;
                }
                campo[i][j] = p;
            }
        }

        int resultado = ex.compute(campo);
        System.out.println(resultado);
    }

    int compute(int[][] campo) {
        int N = campo.length;
        if (N == 0)
            return 0;
        int M = campo[0].length;

        int maxSoma = 0;

        for (int i = 0; i < N; i++) {
            int somaLinha = 0;
            for (int j = 0; j < M; j++) {
                somaLinha += campo[i][j];
            }
            if (somaLinha > maxSoma) {
                maxSoma = somaLinha;
            }
        }

        for (int j = 0; j < M; j++) {
            int somaColuna = 0;
            for (int i = 0; i < N; i++) {
                somaColuna += campo[i][j];
            }
            if (somaColuna > maxSoma) {
                maxSoma = somaColuna;
            }
        }

        return maxSoma;
    }
}