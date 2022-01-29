class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int i = 0;
        
        while (i < s.length()) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                int open = 1;
                int j = i + 1;
                while (j < s.length() && open > 0) {
                    if (s.charAt(j) == '(') {
                        open++;
                    }
                    else if (s.charAt(j) == ')') {
                        open--;
                    }
                    
                    j++;
                }
                
                String blockStr = s.substring(i + 1, j - 1);
                int blockvalue = calculate(blockStr);
                i = j;
                if (sign == '+') {
                    stack.push(blockvalue);
                }
                else if (sign == '-') {
                    stack.push(-blockvalue);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * blockvalue);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / blockvalue);
                }
                
            }
            else if (Character.isDigit(curr)) {
                int val = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                   val = val * 10 + (s.charAt(j) - '0'); 
                    j++;
                }
                
                i = j;
                if (sign == '+') {
                    stack.push(val);
                }
                else if (sign == '-') {
                    stack.push(-val);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * val);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / val);
                }
            }
            else {
                sign = curr;
                i++;
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + stack.pop();
        }
        
        return sum;
    }
}
