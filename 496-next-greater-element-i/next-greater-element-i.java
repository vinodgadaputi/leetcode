import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> nextGreater = new HashMap<>();
        
        // Step 1: Precompute next greater for nums2 using stack
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        
        // Step 2: Answer queries from nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        
        return ans;
    }
}
