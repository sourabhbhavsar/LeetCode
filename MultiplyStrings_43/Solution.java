class Solution {
    public String multiply(String num1, String num2) {
     
        if (num1.equals("0")) {
            return "0";
        }
        
        if (num2.equals("0")) {
            return "0";
        }
        
        // multiplication of ith and jth num goes to i + j location and its carry goes
        // to i + j + 1 location
        int[] numbers = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >=0; j--) {
                
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; //carry
                int p2 = i + j + 1;
                
                int sum = m + numbers[p2];
                
                numbers[p1] = numbers[p1] + (sum / 10); //carry
                numbers[p2] = (sum % 10);
            }
        }
        
        String ans = "";
        for (int n : numbers) {
            if (ans.length() == 0 && n == 0) {
                continue;
            }
            
            ans = ans + n;
        }
        
        return ans;
    }
}
