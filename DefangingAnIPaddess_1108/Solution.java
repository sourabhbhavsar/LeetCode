class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < address.length(); i++) {
            char curr = address.charAt(i);
            
            if (curr == '.') {
                str.append("[.]");
            }
            else {
                str.append(curr);
            }
        }
        
        return str.toString();
    }
}
