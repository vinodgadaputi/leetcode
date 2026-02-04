class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int right = stack.peek();
                
                if (Math.abs(right) == Math.abs(asteroid)) {
                    stack.pop();
                    exploded = true;
                    break;
                } else if (Math.abs(right) < Math.abs(asteroid)) {
                    stack.pop();
                } else {
                    exploded = true;
                    break;
                }
            }
            
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array (LIFO order)
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.removeFirst();
        }
        
        return result;
    }
}
