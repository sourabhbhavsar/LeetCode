class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), 0, ans);
        
        return ans;
    }
    
    public void backtrack(String s, int index, StringBuilder curr, int level, List<String> ans) {
        if (index > s.length() || level > 4) {
            return;
        }
        else if (index == s.length() && level == 4) {
            ans.add(curr.toString());
            return;
        }
        else {
            for (int i = 1; i <= 3; i++) {
                if (index + i > s.length()) {
                    break;
                }
                
                int num = Integer.parseInt(s.substring(index, index + i));
                
                // Checking if num is 0~9 or 10~99 or 100 ~ 255 because leading 0s is invalid.
                if (i == 1 || i == 2 && num >= 10 && num <= 99 || i == 3 && num >= 100 && num <= 255) {
                    curr.append(num);
                    if (level < 3) {
                        curr.append(".");
                    }
                    
                    backtrack(s, index + i, curr, level + 1, ans);
                    
                    if (level < 3) {
                        curr.deleteCharAt(curr.length() - 1);
                    }
                    curr.delete(curr.length() - i, curr.length());
                }
            }
        }
    }
}
