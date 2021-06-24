class Solution {

	// OPtimize krna pdhega yeh solution ni chl rha 

	int minLength = (int)1e9;
    public int coinChange(int[] arr, int idx, int tar, int noOfCoinUsed){
        if(tar == 0){

        	minLength = Math.min(minLength, noOfCoinUsed);

        	return 1;
        }

        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += coinChange(arr, i, tar - arr[i], noOfCoinUsed + 1);
            }
        }
        return count;
    }
    
    public int coinChange(int[] coins, int amount) {
        coinChange(coins, 0, amount, 0);

        return minLength;
    }
}