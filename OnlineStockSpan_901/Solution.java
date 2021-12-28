class StockSpanner {

    Stack<Pair<Integer, Integer>> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }
    
    public int next(int price) {
        int span = 1;
        
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            span= span + stack.pop().getValue();
        }
            
        Pair<Integer, Integer> pair = new Pair<>(price, span);
        stack.push(pair);
        index++;
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
