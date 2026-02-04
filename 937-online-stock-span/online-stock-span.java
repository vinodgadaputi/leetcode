class StockSpanner {
    private Deque<int[]> stack;  // [price, span]
    
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Pop stocks with higher/equal prices, accumulate their spans
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push current [price, span]
        stack.push(new int[]{price, span});
        
        return span;
    }
}
