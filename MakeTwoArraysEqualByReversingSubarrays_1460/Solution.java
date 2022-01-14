class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for (int t : target) {
            int f = map.getOrDefault(t, 0);
            if (f > 1) {
                map.put(t, f - 1);
            }
            else {
                map.remove(t);
            }
        }
        
        return map.size() == 0;
    }
}
