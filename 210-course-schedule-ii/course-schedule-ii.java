import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: prerequisite -> course
        for (int[] pre : prerequisites) {
            int course = pre[0], prerequisite = pre[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int processed = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            order[processed++] = curr;

            for (int next : graph.get(curr)) {
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // If all courses are processed, return order; else empty array
        return processed == numCourses ? order : new int[0];
    }
}