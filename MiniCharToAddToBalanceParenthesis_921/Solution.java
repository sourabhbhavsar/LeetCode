class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == ')') {
                if (stack.isEmpty()) {
                    count++;
                }
                else {
                    stack.pop();
                }              
            }
            else {
                stack.push(curr);
            }
        }
        
        count = count + stack.size();
        
        return count;
    }
}
