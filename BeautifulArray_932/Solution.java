class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        while (ans.size() < n) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i : ans) {
                if (2 * i - 1 <= n) {
                    temp.add(2 * i - 1);
                }
            }
            
            for (int i : ans) {
                if (2 * i  <= n) {
                    temp.add(2 * i);
                }
            }
            
            ans = temp;
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
