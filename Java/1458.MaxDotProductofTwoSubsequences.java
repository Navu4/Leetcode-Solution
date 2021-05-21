class Solution {
    public int maxDotProduct(int[] arr1, int[] arr2, int n, int m, int[][] dp){
    	if(n == 0 || m == 0){
    		return dp[n][m] = -(int)1e9;
    	}

    	if(dp[n][m] != -(int)1e9)
    		return dp[n][m];

    	int ans1 = maxDotProduct(arr1 , arr2, n - 1, m, dp);
    	int ans2 = maxDotProduct(arr1 , arr2, n, m  - 1, dp);
    	int ans3 = maxDotProduct(arr1 , arr2, n - 1, m - 1, dp);
    	int ans4 = arr1[n - 1] * arr2[m - 1] + (ans3 < 0 ? 0 : ans3);

    	return dp[n][m] = Math.max(Math.max(ans1, ans2), Math.max(ans3, ans4));

    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
 		int n = nums1.length;
 		int m = nums2.length;

 		int[][] dp = new int[n + 1][m + 1];
 		for(int[] d : dp){
 			Arrays.fill(d, -(int)1e9);
 		}
 		return maxDotProduct(nums1, nums2, n, m, dp);
    }
}