class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        
        // Sort: col → row → val
        Collections.sort(nodes, (a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : 
            a[1] != b[1] ? a[1] - b[1] : 
            a[2] - b[2]);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        int prevCol = nodes.get(0)[0];
        col.add(nodes.get(0)[2]);
        
        for (int i = 1; i < nodes.size(); i++) {
            int[] node = nodes.get(i);
            if (node[0] == prevCol) {
                col.add(node[2]);
            } else {
                result.add(col);
                col = new ArrayList<>();
                col.add(node[2]);
                prevCol = node[0];
            }
        }
        result.add(col);
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
