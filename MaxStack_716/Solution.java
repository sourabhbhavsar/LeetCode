class MaxStack {

    private Deque<Integer> stack;
    private PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void push(int x) {
        stack.addLast(x);
        pq.offer(x);
    }
    
    public int pop() {
        int item = stack.removeLast();
        pq.remove(item);
        
        return item;
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        int item = pq.poll();
        stack.removeLastOccurrence(item);
        
        return item;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
