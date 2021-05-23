class Solution {
    public int maximumSwap(int num) {    
        if (num < 10) {
            return num;
        }
        
        List<Integer> digits = new ArrayList<>();
        
        while (num != 0) {
            int remainder = num % 10;
            num = num / 10;
            digits.add(0, remainder);
        }
        
        int[] lastPositionOfDigits = new int[10];
        for (int i = 0; i < digits.size(); i++) {
            lastPositionOfDigits[digits.get(i)] = i;
        }
        
        // scane form left to right and for each 
        // digit see if we can find largest number right of it to swap
        for (int i = 0; i < digits.size(); i++) {
            for (int m = 9; m > digits.get(i); m--) {
                int lastPos = lastPositionOfDigits[m];
                 
                 //System.out.println("m = " + m + ", lastPos = " + lastPos + " i = " + i + ", digits.get(i) = " + digits.get(i));
                if (lastPos > i) {
                    int t = digits.get(lastPos);
                    digits.set(lastPos, digits.get(i));
                    digits.set(i, t);
                    
                    return getNumber(digits);
                }
            }
        }
   
        return getNumber(digits);
    }
    
    public int getNumber(List<Integer> digits) {
        int ans = 0;
        int base = 1;
       
        for (int i = digits.size() - 1; i >= 0; i--) {
            ans = ans + base * digits.get(i);
            base = base * 10;
        }
        
        return ans;
    }
}
