import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2. Min‑heap by frequency (keep at most k elements)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest freq
            }
        }

        // 3. Extract elements from heap
        int[] result = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll().getKey();
        }
        return result;
    }
}