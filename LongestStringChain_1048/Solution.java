class Solution {
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> memo = new HashMap<>();
        
        for (String word : words) {
            set.add(word);
        }
        
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, longestStrChainTopDown(word, set, memo));
        }
        
        return ans;
    }
    
    private int longestStrChainTopDown(String word, Set<String> set,  HashMap<String, Integer> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        
        // If the chain start from this word it is at least 1 long.
        int longestChainFromHere = 1;
        for (int i = 0; i < word.length(); i++) {
            // skip ith char
            String nextInChain = word.substring(0, i) + word.substring(i + 1);
            
            if (set.contains(nextInChain)) {
                int skipIchar = 1 + longestStrChainTopDown(nextInChain, set, memo);
                longestChainFromHere = Math.max(longestChainFromHere, skipIchar);
            }
        }
        
        memo.put(word, longestChainFromHere);
        return longestChainFromHere;
    }
}
