class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int islands = 0;

        final int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up, right, down, left

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n, dirs);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n, int[][] dirs) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // mark as visited

        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            dfs(grid, ni, nj, m, n, dirs);
        }
    }
}