class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        
        dfs(ans, num, "", target, 0, 0, 0);
        return ans;
    }
    
    public void dfs(List<String> ans, String num, String path, int target, long preVal, long prevSum, int pos) {
        if (pos == num.length() && prevSum == target) {
            ans.add(path);
            return;
        }
        
        for (int i = pos; i < num.length(); i++) {
           // we can't have numbers with multiple digits started with zero,
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }   
            
            String val = num.substring(pos, i + 1);
            long curr = Long.valueOf(val);
            
            if (pos == 0) {
                dfs(ans, num, path + curr, target, curr, curr, i + 1);
            }
            else {
                dfs(ans, num, path + "+" +  curr, target, curr, prevSum + curr, i + 1);
                dfs(ans, num, path + "-" + curr, target, -curr, prevSum - curr, i + 1);
                dfs(ans, num, path + "*" + curr, target, preVal * curr, prevSum - preVal + preVal * curr, i + 1);
              /** eg.  5 + 3 * 2  should be 11 instead of 16, lets say we are evaluating the last stage 
            preVal will be 3, prevSum will be 8 (5 + 3) from previous operation, and curr will be 2
            prevSum - preVal + preVal * curr ===> 8 - 3 + 3 * 2 = 11 
            and for next round preVal * curr ===> 3 * 2 should be as previous val 2 + (3 * 2) + ...
            */
            }
        }
    }
    
    
}
