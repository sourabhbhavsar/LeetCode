class SparseVector {
    private HashMap<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
    int getValueForIndex(int index) {
        
        int val = 0;
        if (map.containsKey(index)) {
            val = map.get(index);
        }
        
        return val;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        
        for (int index : map.keySet()) {
            int val1 = map.get(index);
            int val2 = vec.getValueForIndex(index);
            
            if (val2 != 0) {
                product = product + val1 * val2;
            }
        }
        
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
