class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum = sum + n;
            int remainder = sum % k;
            if (remainder < 0) {
                remainder = remainder + k;
            }
            if (map.containsKey(remainder)) {
                count = count + map.get(remainder);
                map.put(remainder, map.get(remainder) + 1);
            }
            else {
                map.put(remainder, 1);
            }
        }
        
        return count;
    }
}
