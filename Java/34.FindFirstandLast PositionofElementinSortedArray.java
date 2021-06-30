class Solution {
    public int[] searchRange(int[] nums, int target) {
 		
 		int[] ans = {-1 , -1};

 		int si = 0;
 		int ei = nums.length - 1;

 		// first occurence of elemet
 		while(si <= ei){
 			int mid = (si + ei) / 2;

 			// updating ans[0] again for first occurence 
 			if(nums[mid] == target){
 				ans[0] = mid;

 				ei = mid - 1; 

 			} else if(nums[mid] < target){
 				si = mid + 1;
 			} else {
 				ei = mid - 1;
 			}
 		}       

 		si = 0;
 		ei = nums.length - 1;

 		// last occurence of element
 		while(si <= ei){
 			int mid = (si + ei) / 2;

 			// updating ans[0] again for first occurence 
 			if(nums[mid] == target){
 				ans[1] = mid;

 				si = mid + 1; 

 			} else if(nums[mid] < target){
 				si = mid + 1;
 			} else {
 				ei = mid - 1;
 			}
 		}       
    
 		return ans;
    }
}