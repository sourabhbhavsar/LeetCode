class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int previousNumInSeries = arr[i] - difference;
            int longestEndingAtPrev = map.getOrDefault(previousNumInSeries, 0);
            map.put(arr[i], longestEndingAtPrev + 1);
            
            ans = Math.max(ans, map.get(arr[i]));
        }
        
        return ans;
    }
    
}
