class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int count = 0;
        StringBuilder currStr = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)) {
                count = count * 10 + (curr - '0');
            }
            else if (curr == '[') {
                countStack.push(count);
                strStack.push(currStr);
                
                // reset
                count = 0;
                currStr = new StringBuilder();
            }
            else if (curr == ']') {
                
                // NOTE: Append repeat times currStr in prevStr
                // them make currStr = prevStr 
                StringBuilder prevStr = strStack.pop();
                int repeat =  countStack.pop();
                
                for (int j = 0; j < repeat; j++) {
                    prevStr.append(currStr);
                }
                
                currStr = prevStr;
            }
            else {
                currStr.append(curr);
            }
            
        }
        
        return currStr.toString();
    }
}
