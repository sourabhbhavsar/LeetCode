class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();
        
        even.add("");
        odd.add("0");
        
        // generate single digit palindrome
        // base k will have digits 0 to k
        for (int i = 1; i < k && n > 0; i++) {
            odd.add(Integer.toString(i));
            sum = sum + i;
            n--;
        }
        
        
        return sum + kMirrorHelper(2, k, n, even, odd);
    }
    
    // return the addition of kmirror number of length len
    public long kMirrorHelper(int len, int k, int n, List<String> even, List<String> odd) {
        if (n == 0) {
            return 0;
        }
        
        long sum = 0;
        List<String> list = (len % 2 == 0) ? even : odd;
        List<String> curr = new ArrayList<>();
        
        for (int d = 0; d < k && n > 0; d++) {
            for (int j = 0; j < list.size() && n > 0; j++) {
                String next = d + list.get(j) + d;
                curr.add(next);
                
                Long val = Long.parseLong(next, k);
                
                // skip leading 0
                if (d != 0 && isMirror(Long.toString(val))) {
                    sum = sum + val;
                    n--;
                }
            }
        }
        
        if (len % 2 == 0) {
            even = curr;
        }
        else {
            odd = curr;
        }
        
        return sum + kMirrorHelper(len + 1, k, n, even, odd);
    }

    
    public boolean isMirror(String num) {
        int low = 0;
        int high = num.length() - 1;
        
        while (low < high) {
            if (num.charAt(low) != num.charAt(high)) {
                return false;
            }
            
            low++;
            high--;
        }
        
        return true;
    }
}
