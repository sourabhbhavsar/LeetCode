class Solution {
    public int waysToPartition(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int n = nums.length;
        long sum = Arrays.stream(nums).asLongStream().sum();
        int ans = 0;
        
        long[] diff = new long[n];
        diff[0] = -sum;        
        for (int i = 1; i < n; i++) {
            diff[i] = diff[i - 1] + 2 * nums[i - 1];
            if (diff[i] == 0) {
                ans++;
            }
        }
        
        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> right = new HashMap<>();
        
        for (int i = 1; i < n; i++) {
            right.put(diff[i], right.getOrDefault(diff[i], 0) + 1);
        }
        
        for (int j = 0; j < n; j++) {
            if (j > 0) {
                right.put(diff[j], right.getOrDefault(diff[j], 0) - 1);
                left.put(diff[j], left.getOrDefault(diff[j], 0) + 1);
            }
            
            int count = 0;
            long delta = (long)(k - nums[j]);
            count = count + left.getOrDefault(delta, 0);
            count = count + right.getOrDefault(-delta, 0);
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}
