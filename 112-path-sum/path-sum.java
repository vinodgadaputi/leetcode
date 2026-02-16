class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // No tree → no path
        if (root == null) return false;
        
        // Leaf reached: check if sum matches
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Continue path in left/right subtrees
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || 
               hasPathSum(root.right, remaining);
    }
}
