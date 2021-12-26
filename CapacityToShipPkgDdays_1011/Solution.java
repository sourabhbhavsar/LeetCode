class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // least capacity should be highest weight item
        // max should be the sum of all weights as if they are sent in one day
        // binary search the least that lets us complete in days days
        int sumWeights = 0;
        int maxWeight = weights[0];
        
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
            
            sumWeights = sumWeights + weights[i];
        }
        
        int leastCapacity = maxWeight;
        int maxCapacity = sumWeights;
        
        while (leastCapacity < maxCapacity) {
            int midCapacity = leastCapacity + (maxCapacity - leastCapacity) / 2;
            
            if (isShippingPossibleInKdays(weights, midCapacity, days)) {
                maxCapacity = midCapacity;
            }
            else {
                leastCapacity = midCapacity + 1;
            }
        }
        
        return leastCapacity;
    }
    
    public boolean isShippingPossibleInKdays(int[] weights, int capacity, int k) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
            
            if (sum > capacity) {
                sum = weights[i];
                count++;
            }
        }
        
        return count <= k;
    }
}
