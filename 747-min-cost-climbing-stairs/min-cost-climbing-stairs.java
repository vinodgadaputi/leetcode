class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Best to only use two variables instead of a full dp array
        int prev2 = cost[0];        // cost up to step 0
        int prev1 = cost[1];        // cost up to step 1

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        // Top is beyond last step; min between last two steps' cost
        return Math.min(prev1, prev2);
    }
}