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

	public class NTNPair {
        int maxPossibleAns = -(int) 1e9;
        int NTNMaxSum = 0;
    }

    public int getMax(int... arr) {
        int maxEle = arr[0];
        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
        }
        return maxEle;
    }

    public NTNPair maxPathSum_(TreeNode root) {
        NTNPair myAns = new NTNPair();
        if (root == null) {
            return myAns;
        }

        NTNPair left = maxPathSum_(root.left);
        NTNPair right = maxPathSum_(root.right);

        int onseSidedMax = Math.max(left.NTNMaxSum, right.NTNMaxSum)+ root.val;
        myAns.maxPossibleAns = getMax(left.maxPossibleAns, right.maxPossibleAns, root.val, onseSidedMax,
                left.NTNMaxSum + root.val + right.NTNMaxSum);

        myAns.NTNMaxSum = Math.max(onseSidedMax, root.val);

        return myAns;
    }

    public int maxPathSum(TreeNode root) {
        return maxPathSum_(root).maxPossibleAns;
    }
}