class Solution {
    
    public boolean isPerfectSquareNewton(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        
        return (x * x == num);
    }
    
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        
        long left = 2;
        long right = num / 2;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long guess = (mid * mid);
            if (guess == num) {
                return true;
            }
            else if (guess > num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return false;
    }
    
    
}
