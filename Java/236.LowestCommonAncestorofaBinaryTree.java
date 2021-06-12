/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean rootToNodePath(TreeNode root, TreeNode p, ArrayList<TreeNode> ans){
        if(root == null)
            return false;
        
        boolean res = (root == p) || rootToNodePath(root.left, p, ans) || rootToNodePath(root.right, p, ans);            
        if(res)
            ans.add(root);
        
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        ArrayList<TreeNode> pathQ = new ArrayList<>();
        
        rootToNodePath(root, p , pathP);
        rootToNodePath(root, q , pathQ);
        
        int i = pathP.size() - 1; 
        int j = pathQ.size() - 1;

        
        TreeNode ans = null;
        while(i >= 0 && j >= 0){
            if(pathP.get(i) == pathQ.get(j)){
                ans = pathP.get(i);
                i--;
                j--;
            }
            else 
                break;
        }
        
        return ans;
        
    }
}