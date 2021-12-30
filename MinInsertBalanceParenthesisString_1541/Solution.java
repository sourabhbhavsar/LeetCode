class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                stack.push(i);
                continue;
            }
            
            // now the char is ) we need to check the i + 1 char
            // it has to be a ) or else we will need one insertion
            if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    // adding one (
                    ans = ans + 1;
                }
                i++;
            }
            else {
                //if i + 1 is not ) and stack is not empty then we need to add one )
               if (!stack.isEmpty()) {
                   stack.pop();
                   ans = ans + 1;
               } 
               else {
                   // if stakc is empty and i + 1 is not ) then we need to add one ( and one )
                   ans = ans + 2;
               } 
            } 
        }
        
        // for all the unpaired (  we need to add two )
        ans = ans + 2 * stack.size();
        
        return ans;
    }
}
