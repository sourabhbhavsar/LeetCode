class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        
        int i = getIndexOfFirstSmaller(digits);
        if (i == -1) {
            return -1;
        }
        
        int j = getIndexOfFirstBiggerFrom(digits, i);
        // swap i and j
        char t = digits[i];
        digits[i] = digits[j];
        digits[j] = t;
        
        // reverse from i + 1
        reverse(digits, i + 1);
        
        long ans = Long.parseLong(new String(digits));
        if (ans > Integer.MAX_VALUE) {
            return -1;
        }
        
        return Integer.parseInt(new String(digits));
    }
    
    public void reverse(char[] digits, int index) {
        int i = index;
        int j = digits.length - 1;
        
        while (i < j) {
            char t = digits[i];
            digits[i] = digits[j];
            digits[j] = t;
            i++;
            j--;
        }
    }
    
    public int getIndexOfFirstSmaller(char[] digits) {
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                return i;
            }
        }
        
        return -1;
    }
    
    public int getIndexOfFirstBiggerFrom(char[] digits, int i) {
        for (int j = digits.length - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                return j;
            }
        }
        
        return -1;
    }
}
