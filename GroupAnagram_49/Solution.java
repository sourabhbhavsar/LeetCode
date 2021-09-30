 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        List<List<String>> out = new ArrayList<>();
        for (String key : map.keySet()) {
            out.add(map.get(key));
        }
        
        return out;
    }
}
