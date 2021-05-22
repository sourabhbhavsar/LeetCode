class Solution {
    public int findKthLargest(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        if (k > nums.length) {
            return -1;
        }
        
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int key : freq.keySet()) {
            heap.add(key);
        }
        
        
        while (!heap.isEmpty() && k != 0) {
            int key = heap.poll();
            int frequency = freq.get(key);
            
            if (frequency >= k) {
                return key;
            }
            else {
                k = k - frequency;
            }
        }
        
        return -1;
    }
}
