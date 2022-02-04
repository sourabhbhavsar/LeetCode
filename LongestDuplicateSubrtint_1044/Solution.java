class Solution {
    // modulus value for the rolling hash function to avoid overflow
    int modulus = 1_000_000_007;
    int base = 26;
    
    public String longestDupSubstring(String s) {
        int n = s.length();
        int low = 1;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (findDuplicateOfLength(s, mid) != -1) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        int maxLen = low - 1;
        int start = findDuplicateOfLength(s, maxLen);
        
        return s.substring(start, start + maxLen);
    }
    
    int findDuplicateOfLength(String str, int len) {
        // Compute the hash of string 0 to len - 1 index
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + (str.charAt(i) - 'a')) %  modulus;
        }
        
        Map<Long, List<Integer>> seen = new HashMap<>();
        
        seen.putIfAbsent(hash, new ArrayList<Integer>());
        // the string of length len with this hash starts at 0.
        seen.get(hash).add(0);
        
        // contant value we have to multiply everytime we slide the most signicant char off the window
        long mscMultiplier = 1;
        for (int i = 1; i < len; i++) {
            mscMultiplier = (mscMultiplier * base) % modulus;
        }
        
        for (int i = 1; i < str.length() - len + 1; i++) {
            // Compute rolling hash in O(1) time
            hash = ((hash - (mscMultiplier * (str.charAt(i - 1) - 'a') % modulus)) * base) % modulus;
            hash = (hash + (str.charAt(i + len - 1) - 'a')) % modulus;
            
            if (seen.containsKey(hash)) {
                // Check if the current substring matches any of 
                // the previous substrings with hash.
                String curr = str.substring(i, i + len);
                for (int start : seen.get(hash)) {
                    String candidate = str.substring(start, start + len);
                    
                    if (candidate.equals(curr)) {
                        return start;
                    }
                }
            }
            
            seen.putIfAbsent(hash, new ArrayList<>());
            seen.get(hash).add(i);
            
        }
        
        return -1;
    }
}
