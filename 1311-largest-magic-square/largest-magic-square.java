class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] row = new int[n + 1][m + 1];
        int[][] col = new int[n + 1][m + 1];
        int[][] diag1 = new int[n + 1][m + 1];
        int[][] diag2 = new int[n + 1][m + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(n, m);

        for (int size = maxSize; size >= 2; size--) {
            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= m; j++) {

                    int target = row[i + 1][j + size] - row[i + 1][j];

                    boolean ok = true;

                    for (int r = i; r < i + size; r++) {
                        if (row[r + 1][j + size] - row[r + 1][j] != target) {
                            ok = false;
                            break;
                        }
                    }

                    for (int c = j; c < j + size && ok; c++) {
                        if (col[i + size][c + 1] - col[i][c + 1] != target) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) {
                        int d1 = diag1[i + size][j + size] - diag1[i][j];
                        int d2 = diag2[i + size][j] - diag2[i][j + size];
                        if (d1 != target || d2 != target) ok = false;
                    }

                    if (ok) return size;
                }
            }
        }

        return 1;
    }
}
