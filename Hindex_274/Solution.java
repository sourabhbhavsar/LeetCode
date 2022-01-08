class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            int c = citations[i];
            if (c >= n) {
                buckets[n]++;
            }
            else {
                buckets[c]++;
            }
        }
        
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count = count + buckets[i];
            
            if(count >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
