import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            int pos = findInsertPos(sorted, nums[i]);
            result.add(pos);                // number of elements < nums[i]
            sorted.add(pos, nums[i]);       // keep sorted list
        }

        Collections.reverse(result);
        return result;
    }

    // Binary search: find the first index >= target (like upper_bound)
    private int findInsertPos(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}