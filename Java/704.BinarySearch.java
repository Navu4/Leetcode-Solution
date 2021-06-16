class Solution {
    public int binarySearch(int[] arr, int tar){
        int i = 0, j = arr.length - 1;
        
        while(i <= j){
            int mid = (i + j) / 2;
            
            if(arr[mid] == tar)
                return mid;
            else if(arr[mid] < tar){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }
}