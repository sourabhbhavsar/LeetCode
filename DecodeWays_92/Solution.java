class Solution {

    public int numDecodings(String s) {  
        int[] table = new int[s.length() + 1];
        
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
        
        return numDecodingsBU(s);
    }
    
    public int numDecodingsBU(String s) {
        int[] table = new int[s.length() + 1];
        table[0] = 1;
        
        if (s.charAt(0) == '0') {
           table[1] = 0; 
        }
        else {
            table[1] = 1;
        }
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                table[i] = table[i - 1];
            }
            
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                table[i] = table[i] + table[i - 2];
            }
        }
        
        return table[s.length()];
    }
    
    public int numDecodingsHelper(String s, int index, int[] table) {  
        if (index == s.length()) {
            return 1;
        }
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (table[index] != -1) {
            return table[index];
        }
        
        if (index == s.length() - 1) {
            return 1;
        }
        
        int ans = numDecodingsHelper(s, index + 1, table);
        
        int twoDigit = Integer.parseInt(s.substring(index, index + 2));
        if (twoDigit >= 10 && twoDigit <= 26){
            ans = ans + numDecodingsHelper(s, index + 2, table);
        }
        
     
        table[index] = ans;
        return ans;
    }
    
}
