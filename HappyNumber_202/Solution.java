class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;
    }
    
     public boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    
    
    int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            
            sum = sum + d * d;
        }
        
        return sum;
    }
}
