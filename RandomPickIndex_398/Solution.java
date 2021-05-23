class Solution {
    private HashMap<Integer, List<Integer>> map;
    private Random random;
    private int[] numbers;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        numbers = nums;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
    }
    
    public int pick(int target) {
        if (numbers.length == 0) {
            return 0;
        }
        
        List<Integer> list = map.get(target);
        int min = 0;
        int max = list.size();
        
        int randomIndex = ThreadLocalRandom.current().nextInt(min, max);
        return list.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
