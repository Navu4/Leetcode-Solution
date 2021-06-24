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
    
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder, int lr, int rr) {
        if(idx == preorder.length || preorder[idx] < lr || preorder[idx] > rr)
            return null;
        
        TreeNode node = new TreeNode(preorder[idx++]);
        
        node.left = bstFromPreorder(preorder, lr, node.val);
        node.right = bstFromPreorder(preorder, node.val, rr);
        
        return node;
    }

    
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return bstFromPreorder(preorder, -(int)1e9, (int)1e9);
    }
}