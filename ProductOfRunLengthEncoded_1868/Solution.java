class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        List<Integer> prev = null;
        
        while (i < encoded1.length && j < encoded2.length) {
            int[] e1 = encoded1[i];
            int[] e2 = encoded2[j];
            
            int min = Math.min(e1[1], e2[1]);
            
            int val = e1[0] * e2[0];
            List<Integer> e = new ArrayList<>();
            e.add(val);
            e.add(min);
            
            if (prev != null && prev.get(0) == val) {
                int f = prev.get(1);
                prev.set(1, f + min);
            }
            else {
                prev = e;
                ans.add(e);
            }
            
            e1[1] = e1[1] - min;
            e2[1] = e2[1] - min;
            
            if (e1[1] == 0) {
                i++;
            }
            
            if (e2[1] == 0) {
                j++;
            }
        }
        
      
        return ans;
    }
}
