class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) totalSum += num;
        
        long prefixSum = 0;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            long left = (long)nums[i] * i - prefixSum;
            long right = totalSum - prefixSum - nums[i] - (long)nums[i] * (n - i - 1);
            result[i] = (int)(left + right);
            prefixSum += nums[i];
        }
        return result;
    }
}