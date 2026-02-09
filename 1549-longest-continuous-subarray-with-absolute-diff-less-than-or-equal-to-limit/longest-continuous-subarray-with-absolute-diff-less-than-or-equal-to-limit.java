import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new ArrayDeque<>(); // increasing
        Deque<Integer> maxQ = new ArrayDeque<>(); // decreasing
        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; ++right) {
            // Maintain minQ increasing
            while (!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.pollLast();
            }
            minQ.offerLast(nums[right]);

            // Maintain maxQ decreasing
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(nums[right]);

            // Shrink window if invalid
            while (maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (minQ.peekFirst().equals(nums[left])) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst().equals(nums[left])) {
                    maxQ.pollFirst();
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
