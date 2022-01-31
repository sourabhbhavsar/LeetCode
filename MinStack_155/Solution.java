class MinStack {
    
    StackNode head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new StackNode(val, val, null);
        }
        else {
            // insert at begining
            int min = Math.min(val, head.min);
            head = new StackNode(val, min, head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

class StackNode {
    int val;
    int min;
    StackNode next;
    
    public StackNode(int val, int min, StackNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */