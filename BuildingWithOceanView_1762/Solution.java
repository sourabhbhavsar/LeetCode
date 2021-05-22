class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> out = new ArrayList<>();
        int n = heights.length;
        
        if (n == 1) {
            return new int[1];
        }
        
        int lastTallestBuildingHeight = Integer.MIN_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > lastTallestBuildingHeight) {
                out.add(i);
                
                lastTallestBuildingHeight = heights[i]; 
            }
        }
        
        int[] ans = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            ans[i] = out.get(i);
        }
        
        Arrays.sort(ans);
        
        return ans;
        
    }
}
