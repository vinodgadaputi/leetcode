class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Go left as far as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // No more left: visit root
            curr = stack.pop();
            result.add(curr.val);
            
            // Move to right subtree
            curr = curr.right;
        }
        
        return result;
    }
}
