class Solution {
    public int scoreOfParentheses(String s) {
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(curr);
                curr = 0;
            }
            else {
                curr = stack.pop() + Math.max(2 * curr, 1);
            }
        }
        
        return curr;
    }
}
