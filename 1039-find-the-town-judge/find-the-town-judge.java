class Solution {
        public int findJudge(int n, int[][] trust) {
                int[] score = new int[n + 1]; // 1‑indexed
                        
                                for (int[] t : trust) {
                                            score[t[0]]--;  // t[0] trusts someone → loses trust score
                                                        score[t[1]]++;  // t[1] is trusted → gains trust score
                                                                }
                                                                        
                                                                                // check if any person has exactly (n - 1) trust score
                                                                                        for (int i = 1; i <= n; i++) {
                                                                                                    if (score[i] == n - 1) {
                                                                                                                    return i;
                                                                                                                                }
                                                                                                                                        }
                                                                                                                                                return -1;
                                                                                                                                                    }
                                                                                                                                                    }
