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
    
    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> smallAns){
    	if(root == null)
    		return;

    	if(root.right == null && root.left == null){
    		if(targetSum - root.val == 0){
	    		List<Integer> base = new ArrayList<>(smallAns);
	    		ans.add(base);
    		}
	    	return;
    	}

    	smallAns.add(root.val);

    	pathSum(root.left, targetSum - root.val, ans, smallAns);
    	pathSum(root.right, targetSum - root.val, ans, smallAns);
    	smallAns.remove(smallAns.size() - 1);
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, ans, new ArrayList<>());

        return ans;
    }
}