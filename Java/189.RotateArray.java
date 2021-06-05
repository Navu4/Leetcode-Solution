class Solution {
    // Discussion
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    // My Way 
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr, int i, int j){
        while(i <= j){
            swap(arr, i++, j--);
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1)
            return;
        k = (k % n + n) % n;
        if(k == 0)
            return;
        reverse(nums, 0, n -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, n -1);
        
    }
}