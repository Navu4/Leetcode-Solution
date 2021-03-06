class Solution {
    public int minDistance(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n);
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        int insert = minDistance(s1, s2, n, m - 1, dp);
        int replace = minDistance(s1, s2, n - 1, m - 1, dp);
        int delete = minDistance(s1, s2, n - 1, m, dp);

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[n][m] = replace;
        else
            return dp[n][m] = Math.min(Math.min(insert, replace), delete) + 1;
    }
    
    public int minDistance(String word1, String word2) {
                int n = word1.length(), m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = minDistance(word1, word2, n, m, dp);
        return ans;
    }
}