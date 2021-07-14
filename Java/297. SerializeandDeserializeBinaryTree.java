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
    public void serialize(TreeNode root, String[] str){
        if(root == null){
            str[0] += "# ";
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
    public TreeNode deserialize(String[] str, int[] idx){
        if(str[idx[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[idx[0]]));
        idx[0]++;
        root.left = deserialize(str, idx);
        idx[0]++;
        root.right = deserialize(str, idx);

        return root;
    }

    public TreeNode deserialize(String data) {
        
        String[] str = data.split(" ");
        
        int[] idx = new int[1];
        idx[0] = 0;
        
        return deserialize(str, idx);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));