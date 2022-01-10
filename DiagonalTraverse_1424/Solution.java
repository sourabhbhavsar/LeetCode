class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                
                map.get(key).add(nums.get(i).get(j));
                count++;
            }
        }
        
   
        int[] ans = new int[count];
        int index = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[index++] = list.get(i);
            }
        }
        
        return ans;
    }
}
