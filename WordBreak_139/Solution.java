class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet();
        wordSet.addAll(wordDict);
        
        HashMap<String, Boolean> table = new HashMap<>();
        //return wordBreakBackTracking(s, wordSet);
        return wordBreakDP(s, wordSet, s.length(), table);
    }
    
    public boolean wordBreakBackTracking(String s, Set<String> wordSet) {
        if (wordSet.contains(s)) {
            return true;
        }
        
        // cut string
        for (int i = 0; i < s.length(); i++) {
            String part1 = s.substring(0, i);
            String part2 = s.substring(i);
            
            if (wordSet.contains(part1) && wordBreakBackTracking(part2, wordSet)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean wordBreakDP(String s, 
                               Set<String> wordSet, 
                               int n, 
                               HashMap<String, Boolean> table) {
        if (n == 0) {
            return false;
        }
        
        if (wordSet.contains(s)) {
            return true;
        }
        
        if (table.containsKey(s)) {
            return table.get(s);
        }
            
        String s1 = s.substring(0, n - 1);
        String s2 = s.substring(n - 1);
        
        boolean ans = false;
        
        if (wordSet.contains(s2)) {
            boolean breakHere = wordBreakDP(s1, wordSet, n -1, table);
            boolean notBreakHere = wordBreakDP(s, wordSet, n - 1, table);
            
            ans = breakHere || notBreakHere;
        }
        else {
            ans = wordBreakDP(s, wordSet, n - 1, table);
        }  
        
        table.put(s, ans);
        return ans;
    }
}
