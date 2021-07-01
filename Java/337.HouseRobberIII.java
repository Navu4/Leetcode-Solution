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
    // {with robbery , without robbery}
    public int[] houseRobber(TreeNode root) {
        if(root == null)
            return new int[2];

        int[] lr = houseRobber(root.left);
        int[] rr = houseRobber(root.right);

        int[] myAns = new int[2];
        myAns[0] = lr[1] + rr[1] + root.val;
        myAns[1] = Math.max(lr[0], lr[1]) + Math.max(rr[0], rr[1]);

        return myAns;
    }


    public int rob(TreeNode root) {
        int[] ans = houseRobber(root);
        return Math.max(ans[0], ans[1]);
    }
}