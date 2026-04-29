class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
                int n = rooms.size();
                        boolean[] visited = new boolean[n];
                                
                                        dfs(rooms, visited, 0);
                                                
                                                        // Check if all rooms are visited
                                                                for (int i = 0; i < n; i++) {
                                                                            if (!visited[i]) return false;
                                                                                    }
                                                                                            return true;
                                                                                                }

                                                                                                    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
                                                                                                            visited[room] = true;
                                                                                                                    for (int next : rooms.get(room)) {
                                                                                                                                if (!visited[next]) {
                                                                                                                                                dfs(rooms, visited, next);
                                                                                                                                                            }
                                                                                                                                                                    }
                                                                                                                                                                        }
                                                                                                                                                                        }


        

