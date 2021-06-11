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
     public boolean nodeToRootPath (TreeNode root, int data, ArrayList<TreeNode> ans){
        if (root == null)
            return false;
        boolean res = (root.val == data) || nodeToRootPath(root.left, data, ans)
                || nodeToRootPath(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }
    
    public static void printAtDepthK(TreeNode root, TreeNode block, int k, List<Integer> ans){
        if(root == null || k < 0 || root == block)   return;

        if(k ==0 ){
            ans.add(root.val);
            return;
        }

        printAtDepthK(root.left, block, k -1, ans);
        printAtDepthK(root.right, block, k -1, ans);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target.val, path);
        
        TreeNode block = null;

        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < path.size(); i++){
            printAtDepthK(path.get(i), block, k - i, ans);
            block = path.get(i);
        }

        return ans;
    }
}