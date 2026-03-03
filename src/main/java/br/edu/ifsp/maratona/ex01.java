import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {
        ex01 ex = new ex01();
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
        int C = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Erro");
            return;
        }
        int M = scanner.nextInt();

        if (N < 1 || N > 100 || C < 1 || C > N / 2 || M < 1 || M > 300) {
            System.out.println("Erro");
            return;
        }

        int[] carimbadas = new int[C];
        boolean[] compradas = new boolean[N + 1];

        for (int i = 0; i < C; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Erro");
                return;
            }
            int x = scanner.nextInt();
            if (x < 1 || x > N) {
                System.out.println("Erro");
                return;
            }
            carimbadas[i] = x;
        }

        for (int i = 0; i < M; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Erro");
                return;
            }
            int y = scanner.nextInt();
            if (y < 1 || y > N) {
                System.out.println("Erro");
                return;
            }
            compradas[y] = true;
        }

        int faltam = 0;

        for (int i = 0; i < C; i++) {
            if (!compradas[carimbadas[i]])
                faltam++;
        }

        System.out.println(faltam);
    }
}