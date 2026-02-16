class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // Right first (processes after left due to LIFO)
            if (node.right != null) stack.push(node.right);
            // Left last (processes first)
            if (node.left != null) stack.push(node.left);
        }
        
        return result;
    }
}
