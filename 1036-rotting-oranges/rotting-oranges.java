import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
                    Queue<int[]> q = new ArrayDeque<>();
                            int freshCount = 0;

                                    // Count fresh oranges and enqueue all rotten ones
                                            for (int i = 0; i < m; i++) {
                                                        for (int j = 0; j < n; j++) {
                                                                        if (grid[i][j] == 1) {
                                                                                            freshCount++;
                                                                                                            } else if (grid[i][j] == 2) {
                                                                                                                                q.offer(new int[]{i, j});
                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                                    }

                                                                                                                                                                            if (freshCount == 0) return 0; // already all rotten

                                                                                                                                                                                    final int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up, right, down, left
                                                                                                                                                                                            int minutes = 0;

                                                                                                                                                                                                    while (!q.isEmpty() && freshCount > 0) {
                                                                                                                                                                                                                int size = q.size();
                                                                                                                                                                                                                            minutes++;

                                                                                                                                                                                                                                        for (int k = 0; k < size; k++) {
                                                                                                                                                                                                                                                        int[] curr = q.poll();
                                                                                                                                                                                                                                                                        int x = curr[0], y = curr[1];

                                                                                                                                                                                                                                                                                        for (int[] d : dirs) {
                                                                                                                                                                                                                                                                                                            int nx = x + d[0], ny = y + d[1];
                                                                                                                                                                                                                                                                                                                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                                                                                                                                                                                                                                                                                                                                                        grid[nx][ny] = 2;
                                                                                                                                                                                                                                                                                                                                                                                q.offer(new int[]{nx, ny});
                                                                                                                                                                                                                                                                                                                                                                                                        freshCount--;
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                        return freshCount == 0 ? minutes : -1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

        

