import java.util.Scanner;

public class ex04 {

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        ex04 ex = new ex04();
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        int C = scanner.nextInt();

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int[][] grid = new int[L][C];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int[] finalPos = ex.compute(grid, A - 1, B - 1);
        System.out.println((finalPos[0] + 1) + " " + (finalPos[1] + 1));
    }

    int[] compute(int[][] grid, int startRow, int startCol) {

        int L = grid.length;
        int C = grid[0].length;

        int currentRow = startRow;
        int currentCol = startCol;

        int prevRow = -1;
        int prevCol = -1;

        while (true) {
            int countNext = 0;
            int nextRow = -1;
            int nextCol = -1;

            for (int dir = 0; dir < 4; dir++) {
                int nr = currentRow + dRow[dir];
                int nc = currentCol + dCol[dir];

                if (nr >= 0 && nr < L && nc >= 0 && nc < C) {
                    if (grid[nr][nc] == 1) {
                        if (nr != prevRow || nc != prevCol) {
                            countNext++;
                            nextRow = nr;
                            nextCol = nc;
                        }
                    }
                }
            }

            if (countNext == 0) {
                return new int[]{currentRow, currentCol};
            }

            prevRow = currentRow;
            prevCol = currentCol;

            currentRow = nextRow;
            currentCol = nextCol;
        }
    }
}