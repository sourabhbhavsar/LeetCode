class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    private boolean isEven;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<Integer>();
        small = new PriorityQueue<Integer>(Collections.reverseOrder());
        isEven = true;
    }
    
    public void addNum(int num) {
        if (isEven) {
            large.offer(num);
            int smallestNumFromLargeHalf = large.poll();
            small.offer(smallestNumFromLargeHalf);
        }
        else {
            small.offer(num);
            int largestNumFromSmallHalf = small.poll();
            large.offer(largestNumFromSmallHalf);
        }
        
        isEven = !isEven;
    }
    
    public double findMedian() {
        double ans = 0;
        if (isEven) {
            ans = (small.peek() + large.peek()) / 2.0;
        }
        else {
            ans = small.peek();
        }
        
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
