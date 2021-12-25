class Solution {
    public int maxLength(int[] ribbons, int k) {
        int smallestK = 0;
        int highestK = Integer.MIN_VALUE;
        
        for (int ribbonLength : ribbons) {
            highestK = Math.max(highestK, ribbonLength);
        }
        
        while (smallestK < highestK) {
            // make mid more right biased when you want low = mid to be an option
            // to avoid infite loop.
            int midK = smallestK + (highestK - smallestK + 1) / 2;
            if (isCutPossible(ribbons, k, midK)) {
                smallestK = midK;
            }
            else {
                highestK = midK - 1;
            }
        }
        
        return smallestK;
    }
    
    public boolean isCutPossible(int[] ribbons, int k, int length) {
        int count = 0;
        for (int i = 0; i < ribbons.length; i++) {
            count = count + (ribbons[i] / length);
        }
        
        return (count >= k);
    }
}
