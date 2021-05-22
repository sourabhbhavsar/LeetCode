class Solution {
    
    private String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String ans = numberToWordsHelper(num);
        return ans.trim();
    }
    
    private String numberToWordsHelper(int num) {
        String ans = "";
        
        if (num < 10) {
            ans = belowTen[num];
        }
        else if (num < 20) {
            ans = belowTwenty[num - 10];
        }
        else if (num < 100) {
            ans = belowHundred[num / 10] + " " + numberToWordsHelper(num % 10);
        }
        else if (num < 1000) {
            ans = numberToWordsHelper(num / 100) + " Hundred " +  numberToWordsHelper(num % 100);
        }
        else if (num < 1000000) {
             ans = numberToWordsHelper(num / 1000) + " Thousand " +  numberToWordsHelper(num % 1000);
        }
        else if (num < 1000000000) {
             ans = numberToWordsHelper(num / 1000000) + " Million " +  numberToWordsHelper(num % 1000000);
        }
        else {
            ans = numberToWordsHelper(num / 1000000000) + " Billion " +  numberToWordsHelper(num % 1000000000);
        }
        
        return ans.trim();
    }
}
