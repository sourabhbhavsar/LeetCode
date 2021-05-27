class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) 
        {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) 
            {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
            
                while (low < high) 
                {
                    if (nums[low] + nums[high] == sum) 
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[low]);
                        list.add(nums[i]);
                        list.add(nums[high]);
                        
                        ans.add(list);
                    
                        
                        // skip duplicates
                        while (low < high && nums[low] == nums[low + 1]) 
                        {
                            low++;
                        }
                        
                        while (low < high && nums[high] == nums[high - 1]) 
                        {
                            high--;
                        }
                        
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] > sum) 
                    {
                        high = high - 1;
                    }
                    else 
                    {
                        low = low + 1;
                    }
                }
            }
        }           

        return ans;
    }
}
