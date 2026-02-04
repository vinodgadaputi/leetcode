class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Pass 1: Mark invalid closing parentheses
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '*';  // Mark invalid )
                }
            }
        }
        
        // Pass 2: Mark remaining unmatched opening parentheses
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '*';
        }
        
        // Build result skipping '*'
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
