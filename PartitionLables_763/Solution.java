class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans = new ArrayList<>();
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            lastPos[curr - 'a'] = i;
        }
        
        int substrStart = 0;
        int substrEnd = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            substrEnd = Math.max(substrEnd, lastPos[curr - 'a']);
            
            // did the substring end here?
            if (i == substrEnd) {
                int len = substrEnd - substrStart + 1;
                ans.add(len);
                substrStart = substrEnd + 1;
            }
        }
        
        return ans;
    }
}
