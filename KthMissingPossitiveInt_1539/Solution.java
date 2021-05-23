class Solution {
    public int findKthPositive1(int[] arr, int k) {
        
        int lastNum = 0;
        int countMissingNums = 0;
        int prevCountMissing = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - lastNum;
            if (diff > 1) {
                prevCountMissing = countMissingNums;
                countMissingNums = countMissingNums + diff - 1;
            }
           
            if (countMissingNums >= k) {
                return lastNum + (k - prevCountMissing);
            }
            
            lastNum = arr[i];
        }
        
        return lastNum + (k - countMissingNums);
    }
    
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        
        // If no number was missing then at each index the present vallue would be index + 1.
        // hence if the value at i is A[i], then the number missing till that index i is
        // A[i] - i - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        // it will stop at the maximum index i 
        // where the condition A[i] - i - 1 < k is true
        return low + k;
    }
}
