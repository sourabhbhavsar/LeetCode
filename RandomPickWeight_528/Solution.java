class Solution {
    private int sum;
    private Random random;
    private int[] weight;
    
    public Solution(int[] w) {
        random = new Random();
        
        for (int i : w) {
            sum = sum + i;
        }
        weight = w;
    }
    
    public int pickIndex() {  
        if (weight.length == 1) {
            return 0;
        }
        
        int randomNumber = random.nextInt((sum - 0)) + 0;
        return mapRandomIndex(randomNumber);
    }
    
    public int mapRandomIndex(int index) {
        int nextIndex = 0;
        // System.out.println("********");
        for(int i = 0; i < weight.length; i++) {
            int start = nextIndex;
            int end = start + weight[i] - 1;
            // System.out.println("start = " + start + ", end = " + end + ", index = " + index);
            if (index >= start && index <= end) {
                return i;
            }
            
            nextIndex = end + 1;
        }
        // System.out.println("********");
        return -1;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
