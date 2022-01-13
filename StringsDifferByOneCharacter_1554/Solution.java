class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        int len = dict[0].length();
        for (int i = 0; i < len; i++) {
            set.clear();
            for (String word : dict) {
                String candidate = word.substring(0, i) + word.substring(i + 1);
                if (set.contains(candidate)) {
                    return true;
                }
                
                set.add(candidate);
            }
        }
        
        return false;
    }
}
