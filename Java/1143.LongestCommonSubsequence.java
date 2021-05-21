class Solution {
    // Recursion 
    public int LCSS_recursion(String str1, String str2, int i, int j){
        if(i == -1 || j == -1)
            return 0;

        if(str1.charAt(i) == str2.charAt(j))
            return LCSS_recursion(str1, str2, i - 1 , j - 1) + 1;
        else 
            return Math.max(LCSS_recursion(str1, str2, i - 1, j), LCSS_recursion(str1, str2, i, j - 1));
    } 
    
    // Memoization 
    public static int LCSS_memo(String str1, String str2, int n, int m, int[][] dp){
        if(n == 0 || m == 0)
            return dp[n][m] = 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];

        
        if(str1.charAt(n - 1) == str2.charAt(m - 1))
            return dp[n][m] = LCSS_memo(str1, str2, n - 1 , m - 1, dp) + 1;
        else 
            return dp[n][m] = Math.max(LCSS_memo(str1, str2, n - 1, m, dp), LCSS_memo(str1, str2, n, m - 1, dp));

    }
    
    // DP / TABULAR 
    public int LCSS_DP(String str1, String str2, int N, int M, int[][] dp){

        for (int n = 0; n <= N; n++) {
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                
                if(str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1; // LCSS_memo(str1, str2, n - 1 , m - 1, dp) + 1;
                else 
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);

            }
        }

        return dp[N][M];
    }
    
    public int longestCommonSubsequence(String str1, String str2) {
        
        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);


        return LCSS_DP(str1, str2, n, m, dp);
    }
}