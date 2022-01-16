class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, String> sorted = new TreeMap<>(Collections.reverseOrder());
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char key : map.keySet()) {
            int count = map.get(key);
            String str = sorted.getOrDefault(count, "");
            for (int i = 0; i < count; i++) {
                str = str + key;
            }
            
            sorted.put(count, str);
        }
        

        StringBuilder sb = new StringBuilder();
        for (int key : sorted.keySet()) {
            sb.append(sorted.get(key));
        }
        
        return sb.toString();
    }
}
