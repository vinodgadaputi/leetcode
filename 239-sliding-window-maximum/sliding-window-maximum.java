import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // Remove indices with smaller values from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // First valid window starts at i >= k-1
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
