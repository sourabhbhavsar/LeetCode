class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    public boolean isValid(int num) {
        boolean valid = false;
        
        while (num != 0) {
            
            int lastDigit = num % 10;
            
             /*
                Valid if N contains ATLEAST ONE 2, 5, 6, 9
                AND NO 3, 4 or 7s
             */
            
            if (lastDigit == 2) {
                valid = true;
            }
            else if (lastDigit == 5) {
                valid = true;
            }
            else if (lastDigit == 6) {
                valid = true;
            }
            else if (lastDigit == 9) {
                valid = true;
            }
            else if (lastDigit == 3) {
                return false;
            }
            else if (lastDigit == 4) {
                return false;
            }
            else if (lastDigit == 7) {
                return false;
            }
           
            num = num / 10;
        }
        
        return valid;
    }
}
