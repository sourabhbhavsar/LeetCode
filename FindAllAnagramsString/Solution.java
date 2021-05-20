class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        int begin = 0;
        int end = 0;
        List<Integer> out = new ArrayList<>();
       
        HashMap<Character, Integer> map = new HashMap<>();
        int countUniqueChars = 0;
        
        for (char c : p.toCharArray()) {
           if (map.containsKey(c)) {
               map.put(c, map.get(c) + 1);
           } else {
               map.put(c, 1);
           }
        }
        
        
        countUniqueChars = map.size();
       
        
        int k = p.length();
        
        while (end < s.length()) {
            int windowSize = end - begin + 1;
            
            char c = s.charAt(end);
           
            if (map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, val - 1);
                
                if (val - 1 == 0) {
                    countUniqueChars--;
                }
            }
            
            if (windowSize < k) {
                end++;
            }
            else if (windowSize == k) {
                if (countUniqueChars == 0) {
                    // we have found an anagram here
                    out.add(begin);
                }
                
                char beginChar = s.charAt(begin);
                
                if (map.containsKey(beginChar)) {
                    int val = map.get(beginChar);
                    if (val == 0) {
                        countUniqueChars++;
                    }
                    
                    map.put(beginChar, val + 1);
                    
                }
                
                begin++;
                end++;
            }
        }
        
        return out;
    }
    
    
    public List<Integer> findAnagrams2(String s, String p) {
        int pLen = p.length();
        List<Integer> out = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            String sub = "";
            if (i + pLen < s.length()) {
                sub = s.substring(i, (i + pLen));
            }
            else {
                sub = s.substring(i);
            }
            
            
            
            if (isAnagram(sub, p)) {
                out.add(i);
            }
        }
        
        return out;
    }
    
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char c : s1.toCharArray()) {
            
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            }
            else {
                freq.put(c, 1);                
            }
        }
        
        for (char c : s2.toCharArray()) {
            
            if (freq.containsKey(c)) {
                int val = freq.get(c);
                if (val == 1) {
                    freq.remove(c);
                }
                else {
                    freq.put(c, val - 1);
                }
            }
            else {
                return false;                
            }
        }
        
        return freq.isEmpty();
    }
}
