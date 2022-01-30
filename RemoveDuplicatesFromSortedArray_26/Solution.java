class Solution {
    public int removeDuplicates(int[] nums) {
        int previous = Integer.MIN_VALUE;
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > previous) {
                nums[index] = nums[i];
                index++;
                previous = nums[i];
            }
        }
        
        return index;
    }
}
