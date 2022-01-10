class Solution {
    
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s .toCharArray()) {
            freq[c - 'a']++;
        }
        
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (freq[curr - 'a'] == 1) {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
    
    public int firstUniqChar1(String s) {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (indexMap.containsKey(curr)) {
                int index = indexMap.get(curr);
                list.set(index, '#');
            }
            else {
                list.add(curr);
                indexMap.put(curr, list.size() - 1);
            }
        }
        
        int ans = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != '#') {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
}
