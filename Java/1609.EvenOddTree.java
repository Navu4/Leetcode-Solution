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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return false;

        int level = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);


        while(que.size() != 0){
            int size = que.size();

            int prev = level % 2 == 0 ? 0 : (int)1e6;

            while(size-- > 0){
                TreeNode node = que.removeFirst();
                if(level % 2 == 0){
                    if(node.val % 2 == 0 || prev >= node.val)
                        return false;
                } else {
                    if(node.val % 2 != 0 || prev <= node.val)
                        return false;
                }
                prev = node.val;


                if(node.left != null)
                    que.addLast(node.left);
                if(node.right != null)
                    que.addLast(node.right);
            }

            level++;
        }
        return true;
    }
}