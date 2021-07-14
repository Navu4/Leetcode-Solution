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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
        	return new ArrayList<>();

    	LinkedList<TreeNode> que = new LinkedList<>();
    	que.addLast(root);

    	List<List<Integer>> ans = new ArrayList<>();
        int level = 0;

        while(que.size() != 0){
        	int size = que.size();
        	
        	List<Integer> smallAns = new ArrayList<>();
        	while(size-- > 0){
        		TreeNode node = que.removeFirst();
        		smallAns.add(node.val);

        		if(node.left != null){
        			que.addLast(node.left);
        		}
        	
        		if(node.right != null){
        			que.addLast(node.right);
        		}
        	} 

        	if(level % 2 == 0){
        		ans.add(smallAns);
        	} else {
        		Collections.reverse(smallAns);
        		ans.add(smallAns);
        	}
        	level++;
        }
        return ans;
    }
}