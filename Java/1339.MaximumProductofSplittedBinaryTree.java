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
    
    public long sum(TreeNode root) {
        if(root == null)
            return 0;

        long left = sum(root.left);
        long right = sum(root.right);
                           
        return left + right + root.val;
    }
    
    public long maxProduct(TreeNode root, long sumVal, long[] max){
        if(root == null)
            return 0;
        
        long left = maxProduct(root.left, sumVal, max);
        long right = maxProduct(root.right, sumVal, max);
        
        long rootSum = left + right + root.val;
        max[0] = Math.max(max[0], (sumVal - rootSum) * rootSum);
        
        return rootSum;
    }
    
    public int maxProduct(TreeNode root) {
        long val = sum(root);
        
        long[] max = new long[1];
        maxProduct(root, val, max);
        
        return (int)(max[0] % ((int)1e9 + 7)) ;
    }
}