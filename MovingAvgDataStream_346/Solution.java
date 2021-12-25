class MovingAverage {
    private double sum;
    private Queue<Integer> queue;
    private int size;
    
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }
        
        queue.offer(val);
        sum = sum + val;
        
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
