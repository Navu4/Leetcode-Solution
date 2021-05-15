public class KthSmallestInBinaryTree {
    public int minimum(TreeNode root, int bound) {
        int minLessThanBound = (int)1e9;
        if (root == null)
            return (int) 1e8;
        
        int leftMin = minimum(root.left, bound);
        minLessThanBound = Math.min(minLessThanBound, leftMin);
        
        int rightMin = minimum(root.right, bound);
        minLessThanBound = Math.min(minLessThanBound, rightMin);
        
        if(root.val > bound){
            minLessThanBound = Math.min(minLessThanBound, root.val);
        }
        return minLessThanBound;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        
        int bound = -(int)1e9;
        while(k-- > 0){
            bound = minimum(root, bound);
            System.out.println(bound);
        }
        
        return bound;
    }
}
