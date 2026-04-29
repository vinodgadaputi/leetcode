import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Build red and blue adjacency lists
        List<List<Integer>> red = new ArrayList<>(n);
        List<List<Integer>> blue = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }
        for (int[] e : redEdges) red.get(e[0]).add(e[1]);
        for (int[] e : blueEdges) blue.get(e[0]).add(e[1]);

        // dist[node][color] = shortest distance to node when last edge was red (0) or blue (1)
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // BFS queue: (node, lastColor)
        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0; // reached 0 with last edge red
        dist[0][1] = 0; // reached 0 with last edge blue
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], lastColor = cur[1];

            // Next edge must be the opposite color
            List<List<Integer>> adj = (lastColor == 0) ? blue : red;
            int nextColor = 1 - lastColor;

            for (int v : adj.get(u)) {
                if (dist[v][nextColor] == -1) {
                    dist[v][nextColor] = dist[u][lastColor] + 1;
                    q.offer(new int[]{v, nextColor});
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1 && dist[i][1] == -1) {
                ans[i] = -1;
            } else if (dist[i][0] == -1) {
                ans[i] = dist[i][1];
            } else if (dist[i][1] == -1) {
                ans[i] = dist[i][0];
            } else {
                ans[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return ans;
    }
}