class Solution {
    public int calculate(String s) {
        int sign = 1;
        int num = 0;
        int res = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }
            else if (curr == '+' || curr == '-') {
                res = res + sign * num;
                sign = stack.peek() * (curr == '+' ? 1 : -1);
                num = 0;
            }
            else if (curr == '(') {
                stack.push(sign);
            }
            else if (curr == ')') {
                stack.pop();
            }
        }
        
        res = res + sign * num;
        return res;
    }
}
