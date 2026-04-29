import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        final int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        // Initialize:
        //  - mark zeros as distance 0 and enqueue them
        //  - mark ones as -1 (unvisited)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        // Multi‑source BFS from all 0s
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[i][j] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        return dist;
    }
}