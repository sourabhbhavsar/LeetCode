class Solution {
    public List<String> findStrobogrammatic(int n) {
        
        return findStrobogrammaticHelper(n, n);
        
    }
    
    public List<String> findStrobogrammaticHelper(int n, int originalN) {
        
        if (n == 0) {
            List<String> out = new ArrayList<>();
            out.add("");
            
            return out;
        }
        
        if (n == 1) {
            List<String> out = new ArrayList<>();
            out.add("0");
            out.add("1");
            out.add("8");
            
            return out;
        }
        
        List<String> out = new ArrayList<>();
        List<String> intemerdiate = findStrobogrammaticHelper(n - 2, originalN);
        
        for (int i = 0; i < intemerdiate.size(); i++) {
            String str = intemerdiate.get(i);
            
            if (n != originalN){
                out.add("0" + str + "0");
            }
           
            out.add("1" + str + "1");
            out.add("6" + str + "9");
            out.add("8" + str + "8");
            out.add("9" + str + "6");
        }
        
        return out;
    }
}
