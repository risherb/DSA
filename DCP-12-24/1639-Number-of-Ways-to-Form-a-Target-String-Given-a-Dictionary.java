class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        int mod = 1000000007;
        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }
        long[][] dp = new long[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (target.charAt(i - 1) - 'a' < 26 && freq[target.charAt(i - 1) - 'a'][j - 1] > 0) {
                    dp[i][j] += dp[i - 1][j - 1] * freq[target.charAt(i - 1) - 'a'][j - 1] % mod;
                    dp[i][j] %= mod;
                }
            }
        }
        return (int) dp[m][n];
    }
}
