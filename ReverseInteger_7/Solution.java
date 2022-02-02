class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            int temp = result * 10 + digit;
            
            if (temp / 10 != result) {
                return 0; // overflow; if adding last digit overflows
            }
            
            result = temp;
            x = x / 10;
        }
        
        return result;
    }
}
