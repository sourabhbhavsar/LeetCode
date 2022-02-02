class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 2; i <= n; i++) {
            s = helper(s);
        }
        
        return s;
    }
    
    String helper(String s) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            
            sb.append(String.valueOf(count));
            sb.append(c);
        }
        
        return sb.toString();
    }
}
