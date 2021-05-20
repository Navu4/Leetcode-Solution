class Solution {
    
    // Using helper Function ==> isSafeToPlaceQueen
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = boxes.length, m = boxes[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad < n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }

        return true;
    }

    public static int nqueen_Combination01(boolean[][] boxes, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int n = boxes.length, m = boxes[0].length, count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_Combination01(boxes, tnq - 1, i + 1, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    // =============================================================================


    // Using Boolean arrays for rows, cols, and Diagonals
    static boolean[] rows;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] adiag;

    public int nqueen_Combination03(int n, int m, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nqueen_Combination03(n, m, tnq - 1, i + 1, ans + "(" + r + ", " + c + ") ");
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    
    public int totalNQueens(int n) {
        int m = n;
        rows = new boolean[n];
        cols = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];
        
        // boolean[][] boxes = new boolean[n][m];
        
        return nqueen_Combination03(n, m, n, 0, "");
        // return nqueen_Combination01(boxes, n, 0, "");
    }
}