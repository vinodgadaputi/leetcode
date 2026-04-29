class Solution {
        public int findCircleNum(int[][] isConnected) {
                int n = isConnected.length;
                        boolean[] visited = new boolean[n];
                                int provinces = 0;

                                        for (int i = 0; i < n; i++) {
                                                    if (!visited[i]) {
                                                                    dfs(isConnected, visited, i, n);
                                                                                    provinces++;
                                                                                                }
                                                                                                        }
                                                                                                                return provinces;
                                                                                                                    }

                                                                                                                        private void dfs(int[][] isConnected, boolean[] visited, int city, int n) {
                                                                                                                                visited[city] = true;
                                                                                                                                        for (int neighbor = 0; neighbor < n; neighbor++) {
                                                                                                                                                    if (!visited[neighbor] && isConnected[city][neighbor] == 1) {
                                                                                                                                                                    dfs(isConnected, visited, neighbor, n);
                                                                                                                                                                                }
                                                                                                                                                                                        }
                                                                                                                                                                                            }
                                                                                                                                                                                            }


        
    
