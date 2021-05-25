class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                // check i -1 and i + 1
                int prev = i - 1;
                int next = i + 1;
                
                if (prev >= 0 && flowerbed[prev] != 0) {
                    continue;
                } 
                
                if (next < flowerbed.length && flowerbed[next] != 0) {
                    continue;
                } 
                
                flowerbed[i] = 1;
                n--;
                count++;        
            }
        }
        
        return (n == 0);
                    
    }
}
