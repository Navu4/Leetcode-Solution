class Solution {
    
    public int unCrossedLines(int[] arr1, int[] arr2, int i, int j){
        if(i == 0 || j == 0)
            return 0;
        
        if(arr1[i - 1] == arr2[j - 1])
            return unCrossedLines(arr1, arr2, i - 1, j - 1) + 1;
        else 
            return Math.max(unCrossedLines(arr1, arr2, i - 1, j), unCrossedLines(arr1, arr2, i, j - 1));
    }
    
    public int unCrossedLines_memo(int[] arr1, int[] arr2, int i, int j, int[][] dp){
        if(i == 0 || j == 0)
            return dp[i][j] = 0;
        
        if(dp[i][j] != 0)
            return dp[i][j];
        
        if(arr1[i - 1] == arr2[j - 1])
            return dp[i][j] = unCrossedLines_memo(arr1, arr2, i - 1, j - 1, dp) + 1;
        else 
            return dp[i][j] =  Math.max(unCrossedLines_memo(arr1, arr2, i - 1, j, dp), unCrossedLines_memo(arr1, arr2, i, j - 1, dp));
    }
    
    public int unCrossedLines_DP(int[] arr1, int[] arr2, int I, int J, int[][] dp){
        
        for(int i = 0; i <= I; i++){
            for(int j = 0; j <= J; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }

                if(arr1[i - 1] == arr2[j - 1])
                    dp[i][j] = dp[i - 1][j -1] + 1;
                else 
                    dp[i][j] =  Math.max(dp[i -1][j] , dp[i][j - 1]);
            }
        }
        return dp[I][J];
    }
    
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];

        return unCrossedLines_DP(A, B, n, m, dp);
    }
}