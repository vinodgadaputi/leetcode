class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        int maxFreq = 0;
        int maxCount = 0;
        for (int freq : count) {
            if (freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            } else if (freq == maxFreq) {
                maxCount++;
            }
        }
        int idleSlots = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, idleSlots);
    }
}
