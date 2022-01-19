class Solution {
    public boolean isNumber(String s) {
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        
        s = s.toLowerCase().trim();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr >= '0' && curr <= '9') {
                if (eSeen) {
                    numberAfterE = true;
                }
                else {
                    numberBeforeE = true;
                }
            }
            // + and - can only come as first char or first char after an e
            else if (curr == '+' || curr == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            }
            // dot can only before an e and can only come once
            else if (curr == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                
                dotSeen = true;
            }
            else if (curr == 'e') {
                if (eSeen) {
                    return false;
                }
                
                eSeen = true;
            }
            else {
                return false;
            }
        }
        
        return eSeen ? (numberBeforeE && numberAfterE) : numberBeforeE;
    }
}
