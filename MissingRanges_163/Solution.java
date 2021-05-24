class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
       
        // Find the range between lower and first element in the array.
        // Find ranges between adjacent elements in the array.
        // Find the range between upper and last element in the array.
        
        List<String> out = new ArrayList<String>();
        
        if (nums == null || nums.length == 0) {
            String missingRange = toRange(lower, upper);
            out.add(missingRange);
            
            return out;
        }
        
        if (nums[0] > lower) {
            String missingRange = toRange(lower, nums[0] - 1);
            out.add(missingRange);
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                String missingRange = toRange(nums[i] + 1, nums[i + 1] - 1);
                out.add(missingRange);
            }
        }
        
        
        if (nums[nums.length - 1] < upper) {
            String missingRange = toRange(nums[nums.length - 1] + 1, upper);
            out.add(missingRange);
        }
        
        return out;
    }
    
    public String toRange(int lower, int upper) {
        if (lower == upper) {
            return "" + upper;
        }
        else {
            return lower + "->" + upper;
        }
    }
}
