class Solution {
    public int findMaxLength(int[] nums) {
       // The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j. Also put the sum to index mapping to a HashMap to make search faster.
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        // adding sum = 0 os that iw we see a contiguous sum 
        // from start to end it can be counted.
        sumMap.put(0, -1);
        int max = 0;
        int sum = 0;
        
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            
            if (sumMap.containsKey(sum)) {
                int i = sumMap.get(sum);
                
                
                int window = j - i;
                max = Math.max(max, window);
            }
            else {
                sumMap.put(sum, j);
            }
        }
        
        return max;
    }
}
