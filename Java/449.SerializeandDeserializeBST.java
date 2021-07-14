/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void serialize(TreeNode root, String[] str) {
        if(root == null){
            return;
        }
        
        str[0] += (root.val + " ");
        
        serialize(root.left, str);
        serialize(root.right, str);
    }

    public String serialize(TreeNode root) {
        String[] str = new String[1];
        str[0] = "";
        
        serialize(root, str);
        return str[0];
    }

    
    // Decodes your encoded data to tree.
    public TreeNode bstFromPreorder(String[] preorder, int lr, int rr) {
        if(idx == preorder.length || Integer.parseInt(preorder[idx]) < lr || Integer.parseInt(preorder[idx]) > rr)
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(preorder[idx++]));
        
        node.left = bstFromPreorder(preorder, lr, node.val);
        node.right = bstFromPreorder(preorder, node.val, rr);
        
        return node;
    }

    
    int idx;
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        
        String[] str = data.split(" ");
        idx = 0;
        return bstFromPreorder(str, -(int)1e9, (int)1e9);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;