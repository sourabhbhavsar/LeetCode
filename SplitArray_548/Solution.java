class Solution {
    public boolean splitArray(int[] nums) {
        // i, j and k at least have one element between them
        // and we can not have i and k at the either end of the array
        // has to be of length at least 7.
        if (nums.length < 7) {
            return false;
        }
        
        // j is the middle cut, i is the left cut, k is the right cut.
        
        int[] cummulativeSum = new int[nums.length];
        cummulativeSum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            cummulativeSum[i] = cummulativeSum[i - 1] + nums[i];
        }
        
        // try all middle indexes.
        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> set = new HashSet<>();
            // try all left cuts
            for (int i = 1; i < j - 1; i++) {
                // 0 to i - 1
                int sumZI = cummulativeSum[i - 1];
                // i + 1 to j - 1
                int sumIJ = cummulativeSum[j - 1] - cummulativeSum[i];
                
                if (sumZI == sumIJ) {
                    set.add(sumIJ);
                }
            }
            
            // try all right cuts
            for (int k = j + 2; k < nums.length - 1; k++) {
                // k + 1 to n - 1
                int sumKN = cummulativeSum[nums.length - 1] - cummulativeSum[k];
                // j + 1 to k - 1
                int sumJK = cummulativeSum[k - 1] - cummulativeSum[j];
                
                if (sumKN == sumJK) {
                    if (set.contains(sumKN)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
}
