class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] piles = new int[n];
        
        piles[0] = nums[0];
        int pileSize = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < piles[0]) {
                piles[0] = nums[i]; // place it over the lest most larger num
            }
            else if (nums[i] > piles[pileSize - 1]) {
                piles[pileSize] = nums[i]; // if current card is higher than the top card of rihtmost pile, start a new pile
                pileSize++;
            }
            else {
                int index = findLeftMostPileWithTopLargerThanX(piles, pileSize, nums[i]);
                piles[index] = nums[i];
            }
        }
        
        return pileSize;
    }
    
    int findLeftMostPileWithTopLargerThanX(int[] piles, int pileSize, int x) {
        int low = 0;
        int high = pileSize - 1;
        
        while (low < high) {
            int mid = (high + low) / 2;
            if (piles[mid] >= x) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    int lis(int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;
  
        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;
  
        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
  
        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
  
        return max;
    }

}
