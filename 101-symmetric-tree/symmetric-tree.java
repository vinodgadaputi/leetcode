class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both empty → symmetric ✓
        if (t1 == null && t2 == null) return true;
        // One empty → not symmetric ✗
        if (t1 == null || t2 == null) return false;
        // Values differ → not symmetric ✗
        if (t1.val != t2.val) return false;
        
        // ✅ CORRECT: Cross-mirror children
        return isMirror(t1.left, t2.right) && 
               isMirror(t1.right, t2.left);
    }
}
