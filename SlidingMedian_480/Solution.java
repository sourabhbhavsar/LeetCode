class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (right.size() > left.size()) {
                right.offer(nums[i]);
                left.offer(right.poll());
            }
            else {
                left.offer(nums[i]);
                right.offer(left.poll());
            }
            
            // if we have reached window size k 
            if (left.size() + right.size() == k) {
                double median = 0;
                
                if (left.size() == right.size()) {
                    median = (double)((long)left.peek() + (long)right.peek()) / 2.0;
                }
                else {
                    median = (double)right.peek();
                }
                
                int start = i - k + 1;
                ans[start] = median;
                // remove the leftmeost element
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        
        return ans;
    }
}
