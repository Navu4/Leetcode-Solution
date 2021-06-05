class Result {

    /*
     * Complete the 'ways' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY coins
     */
    

    // Target with Infinite  Coins
    // Using DP 
    public static long ways_(int n, List<Integer> coins, int idx, long[][] dp){
        if(n == 0){
            return dp[n][idx] = 1;
        }
        
            if(dp[n][idx]!=-1){
            return dp[n][idx];
        }
        long count = 0;
        for(int i = idx; i < coins.size(); i++){
            if(n - coins.get(i) >= 0){
                count += ways_(n - coins.get(i), coins, i, dp);
            }
        }
        return dp[n][idx] = count;
    }
    
    public static long ways(int n, List<Integer> coins) {
    // Write your code here
        long[][] dp = new long[n + 1][coins.size() + 1];
        
        for(long[] d: dp){
            Arrays.fill(d,-1);
        }
        return ways_(n, coins, 0, dp);
    }

}