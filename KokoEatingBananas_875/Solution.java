class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMaxPile(piles);
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canEatPilesAtK(piles, h, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    boolean canEatPilesAtK(int[] piles, int h, int k) {
        int totalHour = 0;
        for (int p : piles) {
            totalHour = totalHour + (p / k);
            if (p % k != 0) {
                totalHour++;
            }
        }
        
        return totalHour <= h;
    }
    
    int getMaxPile(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        
        return max;
    }
   
}
