class Solution {
    public int coinChange(int[] arr, int idx, int tar, int noOfCoinUsed){
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += coinChange(arr, i, tar - arr[i], noOfCoinUsed)
            }
        }
        return count;
    }
    
    public int coinChange(int[] coins, int amount) {
        
    }
}