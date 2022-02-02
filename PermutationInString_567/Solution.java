class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int begin = 0;
        int end = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int charCount = s1.length();
        
        while (end < s2.length()) {
            char curr = s2.charAt(end);
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0) {
                    charCount--;
                }
                
                map.put(curr, map.get(curr) - 1);
            }
            
            while (charCount == 0) {
                int window = end - begin + 1;
                if (window == s1.length()) {
                    return true;
                }
                
                char front = s2.charAt(begin);
                if (map.containsKey(front)) {
                    map.put(front, map.get(front) + 1);
                    
                    if (map.get(front) > 0) {
                        charCount++;
                    }
                }
                
                begin++;
            }
            
            end++;
        }
        
        return false;
    }
}
