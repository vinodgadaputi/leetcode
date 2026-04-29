class Solution {
        public int maxAreaOfIsland(int[][] grid) {
                if (grid == null || grid.length == 0) return 0;
                        
                                int m = grid.length, n = grid[0].length;
                                        int maxArea = 0;
                                                int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up, right, down, left

                                                        for (int i = 0; i < m; i++) {
                                                                    for (int j = 0; j < n; j++) {
                                                                                    if (grid[i][j] == 1) {
                                                                                                        maxArea = Math.max(maxArea, dfs(grid, i, j, m, n, dirs));
                                                                                                                        }
                                                                                                                                    }
                                                                                                                                            }

                                                                                                                                                    return maxArea;
                                                                                                                                                        }

                                                                                                                                                            private int dfs(int[][] grid, int i, int j, int m, int n, int[][] dirs) {
                                                                                                                                                                    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
                                                                                                                                                                                return 0;
                                                                                                                                                                                        }

                                                                                                                                                                                                grid[i][j] = 0;  // mark as visited
                                                                                                                                                                                                        int area = 1;

                                                                                                                                                                                                                for (int[] d : dirs) {
                                                                                                                                                                                                                            int ni = i + d[0], nj = j + d[1];
                                                                                                                                                                                                                                        area += dfs(grid, ni, nj, m, n, dirs);
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                        return area;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            }


        
    
