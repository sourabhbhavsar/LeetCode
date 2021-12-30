class Solution {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        Character[] digits = new Character[]{res[0],res[1],res[3],res[4]};
        
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(digits));
        
        res[4] = findNext(set, res[4], '9');
        if (time.charAt(4) < res[4]) {
            return new String (res);
        }
        
        res[3] = findNext(set, res[3], '5');
        if (time.charAt(3) < res[3]) {
            return new String (res);
        }
        
        char l = '\0';
        if (res[0] == '2') {
            l = '3';
        }
        else {
            l = '9';
        }
        
        res[1] = findNext(set, res[1], l);
        if (time.charAt(1) < res[1]) {
            return new String (res);
        }
        
        res[0] = findNext(set, res[0], '2');
        
        return new String(res);
    }
    
    public char findNext(TreeSet<Character> set, char c, char limit) {
        Character next = set.higher(c);
        
        if (next == null || next > limit) {
            return set.first();
        }
        
        return next;
    }
}
