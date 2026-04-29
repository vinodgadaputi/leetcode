import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Min‑heap: [sum, index1, index2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Push first k pairs (nums1[i], nums2[0])
        int n1 = nums1.length, n2 = nums2.length;
        for (int i = 0; i < Math.min(n1, k); i++) {
            int sum = nums1[i] + nums2[0];
            minHeap.offer(new int[]{sum, i, 0});
        }

        while (!minHeap.isEmpty() && k > 0) {
            int[] top = minHeap.poll();
            int i = top[1], j = top[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Push next candidate: (nums1[i], nums2[j+1]), if exists
            if (j + 1 < n2) {
                int newSum = nums1[i] + nums2[j + 1];
                minHeap.offer(new int[]{newSum, i, j + 1});
            }
        }

        return result;
    }
}