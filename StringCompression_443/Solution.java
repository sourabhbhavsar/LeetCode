class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
    
        while (i < chars.length) {
            char curr = chars[i];
            int count = 0;
            
            while (i < chars.length && chars[i] == curr) {
                count++;
                i++;
            }
            
            chars[index++] = curr;
            if (count > 1) {
                char[] nums = Integer.toString(count).toCharArray();
                
                for (char n : nums) {
                     chars[index++] = n;
                }
               
            }
        }
        
        return index;
    }
}
