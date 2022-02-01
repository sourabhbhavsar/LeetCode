class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        
        List<Integer> ans = new ArrayList<>();
        
        for (int n : nums2) {
            if (map.containsKey(n)) {
                ans.add(n);
                
                map.put(n, map.get(n) - 1);
                map.remove(n, 0);
            }
        }
        
        int[] res = new int[ans.size()];
        int index = 0;
        for (int i : ans) {
            res[index++] = i;
        }
        
        return res;
    }
}
