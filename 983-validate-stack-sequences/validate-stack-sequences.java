class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int poppedIndex = 0;
        
        for (int num : pushed) {
            stack.push(num);
            
            // Keep popping while stack top matches next expected pop
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        
        // Stack must be empty for valid sequence
        return stack.isEmpty();
    }
}
