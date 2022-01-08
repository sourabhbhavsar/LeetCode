class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                stack.push(curr);
            }
            else if (curr == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            
            int depth = stack.size();
            max = Math.max(max, depth);
        }
        
        return max;
    }
}
