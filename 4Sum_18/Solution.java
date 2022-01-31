class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if (curr == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        
                        left++;
                        right--;
                        
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;;
                        }
                    }
                    else if (curr < target) {
                        left++;
                    }
                    else if (curr > target) {
                        right--;
                    }
                }
            }
        }
        
        return ans;
    }
}
