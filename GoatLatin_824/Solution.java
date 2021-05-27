class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        
        int index = 0;
        String suffix = "a";
        String vowelSuffix = "ma";
        
        for (int i = 0; i < words.length; i++) {
            if (startsWithVowel(words[i])) {
                words[i] = words[i] + vowelSuffix + suffix;
                suffix = suffix + 'a';
            }
            else {
                
                if (words[i].length() > 1) {
                    char firstChar = words[i].charAt(0);
                    words[i] = words[i].substring(1);
                    words[i] = words[i] + firstChar + "ma" + suffix;
                } 
                else {
                    words[i] = words[i] + "ma" + suffix;
                }
                
                suffix = suffix + 'a';
            }
        }
        
        String ans = "";
        for (String str : words) {
            ans = ans + str + " ";
        }
        
        return ans.trim();
    }
    
    public boolean startsWithVowel(String str) {
        if (str.equals("")) {
            return false;
        }
        
        char firstChar = str.charAt(0);
        firstChar = Character.toUpperCase(firstChar);
        
        if (firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') {
            return true;
        } 
        
        return false;
    }
}
