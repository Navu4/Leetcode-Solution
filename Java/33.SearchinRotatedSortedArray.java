class Solution {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while(si <= ei){

        	int mid = (si + ei ) / 2;
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[si] <= nums[mid]){
        		// First Half Sorted
        		if(target >= nums[si] && target < nums[mid]){
        			ei = mid - 1;
        		} else {
        			si = mid + 1;
        		}

        	}
        	else if(nums[mid] <= nums[ei]){
        		// Second Half Sorted
        		if(target <= nums[ei] && target > nums[mid]){
        			si = mid + 1;
        		} else {
        			ei = mid - 1;
        		}
        	}

        }

        return -1;
    }
}

// IMPORTANT EDGE CASE 
// [3,1]
// 1