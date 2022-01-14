class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = getCompact(s);
        String s2 = getCompact(t);
        
        return s1.equals(s2);
    }
    
    public String getCompact(String s) {
        int count = 0;
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            }
            else {
                if (count > 0) {
                    count--;
                }
                else {
                    s1 = s1 + s.charAt(i);
                }
            }
        }
        
        return s1;
    }
    
    public String getActualStr(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
