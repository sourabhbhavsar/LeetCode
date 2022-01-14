class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() == 1) {
            return "";
        }
        char[] array = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (array[i] !=  'a') {
                array[i] = 'a';
                
                return new String(array);
            }
        }
        
        array[array.length - 1] = 'b';        
        
        return new String(array);
    }
}
