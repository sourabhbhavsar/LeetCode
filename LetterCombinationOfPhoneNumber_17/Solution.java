class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', Arrays.asList());
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        
        helper(digits, "", 0, ans, map);
        return ans;
    }
    
    public void helper(String digits, String curr, int digitsPos, List<String> ans, Map<Character, List<String>> map) {
        if (curr.length() == digits.length()) {
            ans.add(curr);
        }
        
        for (int i = digitsPos; i < digits.length(); i++) {
            List<String> letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.size(); j++) {
                curr = curr + letters.get(j);
                helper(digits, curr, i + 1, ans, map);
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
    
}
