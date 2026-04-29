import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list and in‑degree array
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0], prerequisite = pre[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // BFS: start with all nodes that have in‑degree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int taken = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            taken++;
            for (int next : graph.get(curr)) {
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return taken == numCourses;
    }
}