class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        char[] array = s.toCharArray();
        
        reverse(array, 0, n - 1);
        reverseWords(array, n);
        return cleanSpacer(array, n);
    }
    
    String cleanSpacer(char[] array, int n) {
        int i = 0; 
        int j = 0;
        
        while (j < n) {
            while (j < n && array[j] == ' ') { // skip spaces
                j++;
            }
            
            while (j < n && array[j] != ' ') { // keep non spaces
                array[i++] = array[j++];
            }
            
            while (j < n && array[j] == ' ') { // skip spaces
                j++;
            }
            
            if (j < n) {  // keep only one space
                array[i++] = ' ';
            }
            
        }
        
        return new String(array).substring(0, i);
    }
    
    void reverseWords(char[] array, int n) {
        int i = 0; 
        int j = 0;
        
        while (i < n) {
            while (i < j || i < n && array[i] == ' ') { // skip spaces
                i++;
            }
            
            while (j < i || j < n && array[j] != ' ') { // skip non spaces
                j++;
            }
            
            reverse(array, i, j - 1);
        }
        
    }
    
    void reverse(char[] array, int low, int high) {
        
        while (low < high) {
            char t = array[low];
            array[low] = array[high];
            array[high] = t;
            
            low++;
            high--;
        }
    }
}
