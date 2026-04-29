import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
            // Build adjacency list
                    List<List<Integer>> adj = new ArrayList<>();
                            for (int i = 0; i < n; i++) {
                                        adj.add(new ArrayList<>());
                                                }
                                                        for (int[] e : edges) {
                                                                    adj.get(e[0]).add(e[1]);
                                                                                adj.get(e[1]).add(e[0]);
                                                                                        }
                                                                                                
                                                                                                        // DFS from source
                                                                                                                boolean[] visited = new boolean[n];
                                                                                                                        return dfs(adj, source, destination, visited);
                                                                                                                            }

                                                                                                                                private boolean dfs(List<List<Integer>> adj, int curr, int dest, boolean[] visited) {
                                                                                                                                        if (curr == dest) return true;
                                                                                                                                                if (visited[curr]) return false;
                                                                                                                                                        
                                                                                                                                                                visited[curr] = true;
                                                                                                                                                                        for (int neighbor : adj.get(curr)) {
                                                                                                                                                                                    if (dfs(adj, neighbor, dest, visited)) {
                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                return false;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    }