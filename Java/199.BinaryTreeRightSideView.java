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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-- > 0){
                TreeNode rNode = que.removeFirst();
                
                if(rNode.right != null)
                    que.addLast(rNode.right);
                
                if(rNode.left != null)
                    que.addLast(rNode.left);

            }
        }

        return ans;
    }
}