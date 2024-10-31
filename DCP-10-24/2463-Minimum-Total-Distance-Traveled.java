class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int n = robot.size(), m = factory.length;
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        dp[0][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                long dist = 0;
                for (int k = 1; k <= Math.min(factory[i - 1][1], j); k++) {
                    dist += Math.abs(factory[i - 1][0] - robot.get(j - k));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + dist);
                }
            }
        }
        
        return dp[m][n];
    }
}