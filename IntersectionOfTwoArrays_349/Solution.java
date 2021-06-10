class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for (int n : nums1) {
            set.add(n);
        }
        
        for (int n : nums2) {
            if (set.contains(n)) {
                intersect.add(n);
            }
        }
        
        int[] ans = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            ans[index++] = num;
        }
        
        return ans;
    }
}
