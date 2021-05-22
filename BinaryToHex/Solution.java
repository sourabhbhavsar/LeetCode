class Solution {
    public String toHex(int num) {
        
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder("");
        
        char[] map = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b' ,'c', 'd', 'e', 'f'};
        
        while (num != 0) {
            int m = (num & 15);
            sb.append(map[m]);
            num = num >>> 4;
        }
        
        return sb.reverse().toString();
    }
}
