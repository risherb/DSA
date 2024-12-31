class Solution {
    private int[] dp;
    private int n;

    private int helper(int[] days, int[] costs, int i) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        // 1-day pass
        int oneDayPass = costs[0] + helper(days, costs, i + 1);

        // 7-day pass
        int j = i;
        while (j < n && days[j] < days[i] + 7) {
            j ++;
        }
        int sevenDayPass = costs[1] + helper(days, costs, j);

        // 30-day pass
        j = i;
        while (j < n && days[j] < days[i] + 30) {
            j ++;
        }
        int thirtyDayPass = costs[2] + helper(days, costs, j);

        return dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));

    }

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return helper (days, costs, 0);
    }
}