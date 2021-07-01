/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public int getMax(int... arr){
		int maxEle = arr[0];
		for(int ele : arr)
			maxEle = Math.max(maxEle, ele);

		return maxEle;
	}

	public int longestZigZag_(TreeNode root) {
        if(root ==  null)
        	return new int[3];

        int lr = longestZigZag_(root.left);
        int rr = longestZigZag_(root.right);

        int[] myAns = new int[3];
        myAns[0] = lr[1] + 1;
        myAns[1] = rr[0] + 1;

        myAns[2] = getMax(myAns[0], myAns[1] , lr[2] , rr[2]);

        return myAns;
    }


    public int longestZigZag(TreeNode root) {
        int[] ans = longestZigZag_(root);
    	return ans[2];
    }
}
