class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Pop prices that current can discount
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        
        // Remaining prices get no discount
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices[idx];
        }
        
        return answer;
    }
}
