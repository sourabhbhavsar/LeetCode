class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.push(curr);
            }
            else {
                char top = stack.peek();
                if (top == curr) {
                    stack.pop();
                }
                else {
                    stack.push(curr);
                }
            }
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;     
        }
        
        return ans;
    }
}
