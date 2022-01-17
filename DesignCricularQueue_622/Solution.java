class MyCircularQueue {
    int[] array;
    int front;
    int rear;
    int size;
    
    public MyCircularQueue(int k) {
        array = new int[k];
        front = 0;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        front = (front + 1) % array.length;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        
        return array[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        return array[rear];
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        
        return false;
    }
    
    public boolean isFull() {
        if (size == array.length) {
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
