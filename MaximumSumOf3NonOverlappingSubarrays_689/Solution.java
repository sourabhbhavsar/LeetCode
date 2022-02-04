class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;
        int[] ans = new int[3];
        
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // posLeft[i] means if the middle interval start index is i, what's the index for left interval 
        // such that left interval has the maximum sum.
        // initial value is 0 because if middle interval start index is k, then left interval start index is 0.
        int[] posLeft = new int[n];
        
        // posRight[i] means if the middle interval start index is i, what's the index for right interval 
        // such that right interval has the maximum sum.
        // initial value is 0 because if middle interval start index is n- 1 - k, then right interval start index is n - 1.
        int[] posRight = new int[n];
        
        int total = prefixSum[k] - prefixSum[0];
        for (int i = k; i < n; i++) {
            if (prefixSum[i + 1] - prefixSum[i + 1 - k] > total) {
                posLeft[i] = i + 1 - k;
                total = prefixSum[i + 1] - prefixSum[i + 1 - k];
            }
            else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        
        
        posRight[n-k] = n-k;
        total = prefixSum[n] - prefixSum[n - k];
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        for (int i = n - 1 - k ; i >= 0; i--) {
            if (prefixSum[i + k] - prefixSum[i] >= total) {
                posRight[i] = i;
                total = prefixSum[i + k] - prefixSum[i];
            }
            else {
                posRight[i] = posRight[i + 1];
            }
        }
        
        for (int i = k; i <= n - 2 * k; i++) {
            int left = posLeft[i - 1];
            int right = posRight[i + k];
            
            int localMax = (prefixSum[i + k] - prefixSum[i]) + (prefixSum[left + k] - prefixSum[left]) + (prefixSum[right + k] - prefixSum[right]);
            if (localMax > maxSum) {
                maxSum = localMax;
                
                ans[0] = left;
                ans[1] = i;
                ans[2] = right;
            }
        }
        
        return ans;
    }
}
