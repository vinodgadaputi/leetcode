class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        buildPaths(root, "", result);
        return result;
    }
    
    private void buildPaths(TreeNode node, String path, List<String> result) {
        // Add current node to path
        String newPath = path.length() == 0 ? 
            String.valueOf(node.val) : 
            path + "->" + node.val;
        
        // Leaf: add complete path
        if (node.left == null && node.right == null) {
            result.add(newPath);
            return;
        }
        
        // Recurse on children
        if (node.left != null) {
            buildPaths(node.left, newPath, result);
        }
        if (node.right != null) {
            buildPaths(node.right, newPath, result);
        }
    }
}
