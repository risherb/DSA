class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] < grid[i][j + 1])
                    dp[i][j] = dp[i][j + 1] + 1;
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1])
                    dp[i][j] = max(dp[i][j], dp[i - 1][j + 1] + 1);
                if (i < m - 1 && grid[i][j] < grid[i + 1][j + 1])
                    dp[i][j] = max(dp[i][j], dp[i + 1][j + 1] + 1);
            }
        }

        int y = dp[0][0];
        for (int i = 0; i < m; i++)
            y = max(y, dp[i][0]);

        return y;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}