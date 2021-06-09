class Solution {
    /*
    Intuition

When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string. For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on. This means that after parsing the first i symbols, (which may include asterisks,) we only need to keep track of what the balance could be.

For example, if we have string '(***)', then as we parse each symbol, the set of possible values for the balance is [1] for '('; [0, 1, 2] for '(*'; [0, 1, 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.

Furthermore, we can prove these states always form a contiguous interval. Thus, we only need to know the left and right bounds of this interval. That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3].
    
    */
    
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        
        for (char curr : s.toCharArray()) {
            if (curr == '(') {
                low++;
                high++;
            }
            else if (curr == ')') {
                low = Math.max(low - 1, 0);
                high--;
            }
            else {
                low = Math.max(low - 1, 0); // * as )
                high++; // * as (
            }
            
            if (high < 0) {
                return false;
            }
        }
        
        return low == 0;
    }
}
