class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char curr : t.toCharArray()) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int tCharCount = t.length();
        int begin = 0;
        int end  = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
    
        int n = s.length();
        
        while (end < n) {
            char curr = s.charAt(end);
             //System.out.println("curr = " + curr + " end = " + end);
            
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0) {
                    tCharCount--;
                }
                map.put(curr, map.get(curr) - 1);
            }
            
            while (tCharCount == 0) {
                int len = end - begin + 1;
                //System.out.println("Begin = " + begin + " end = " + end);
                if (len < minLen) {
                    minLen = len;
                    minLeft = begin;
                    minRight = end;
                }
                
                char front = s.charAt(begin);
                if (map.containsKey(front)) {
                    map.put(front, map.get(front) + 1);
                    if (map.get(front) > 0) {
                        tCharCount++;
                    }
                }
                
                begin++;
            }
            
            end++;
        }
        
        if (minLen > s.length()) {
            return "";
        }
        
        return s.substring(minLeft, minRight + 1);
    }
}
