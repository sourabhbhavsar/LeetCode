class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int n = s.length();
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String pattern = s.substring(0, i);
                
                int times = n / i;
                
                StringBuilder sb = new StringBuilder();
                for (int t = 0; t < times; t++) {
                    sb.append(pattern);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
