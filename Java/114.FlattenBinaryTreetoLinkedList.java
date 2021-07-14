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
    public TreeNode rightMostNode(TreeNode curr){
        while(curr.right != null)
            curr = curr.right;
        
        return curr;
    }
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        
        if(root.left != null){
            flatten(root.left);

            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode tailOfLeft = rightMostNode(root.left);

            tailOfLeft.right = temp;

            root.left = null;
        }
        
        flatten(root.right);
    }
}