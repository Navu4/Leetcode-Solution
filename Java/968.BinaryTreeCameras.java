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
    // -1 : Camera required
    // 0 : Already covered
    // 1 : I'm a camera
    public int minCameraCover(TreeNode root, int[] countNoOfCamera) {
        if(root == null)
            return 0;

        int ln = minCameraCover(root, countNoOfCamera);
        int rn = minCameraCover(root, countNoOfCamera);

        if(ln == -1 || rn == -1){
            countNoOfCamera[0]++;
            return 1;
        }

        if(ln == 1 || rn == 1)
            return 0;

        return -1;
    }

    public int minCameraCover(TreeNode root) {
        int[] countNoOfCamera = {0};
        int ans = minCameraCover(root, countNoOfCamera);

        if(ans == -1)
            countNoOfCamera[0]++;

        return countNoOfCamera[0];
    }

}