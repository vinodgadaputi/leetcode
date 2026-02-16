class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    
    private void pathSumHelper(TreeNode node, int remaining, 
                              List<Integer> currentPath, 
                              List<List<Integer>> result) {
        // Base case: no node
        if (node == null) return;
        
        // Add current value to path
        currentPath.add(node.val);
        
        // Leaf check: sum matches and no children
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recurse on children with reduced sum
            pathSumHelper(node.left, remaining - node.val, currentPath, result);
            pathSumHelper(node.right, remaining - node.val, currentPath, result);
        }
        
        // Backtrack: remove current value
        currentPath.remove(currentPath.size() - 1);
    }
}
