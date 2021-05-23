class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strings) 
        {
            if (str.length() == 1) {
                List<String> list = map.getOrDefault("1", new ArrayList<>());
                list.add(str);
                map.put("1", list);
            }
            else {
                String pattern = "0";
                for (int i = 0; i < str.length() - 1; i++) {
                    int diff = (str.charAt(i) - 'a') - (str.charAt(i + 1) - 'a');
                    if (diff < 0) {
                        diff = diff + 26;
                    }
                    pattern = pattern + diff;
                }
                // System.out.println("pattern = " + pattern + ", str = " + str);
                
                List<String> list = map.getOrDefault(pattern, new ArrayList<>());
                list.add(str);
                
                map.put(pattern, list);
            }            
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
}
