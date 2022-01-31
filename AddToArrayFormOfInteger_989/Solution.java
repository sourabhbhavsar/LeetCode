class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int sum = 0;
        int carry = k;
        List<Integer> ans = new ArrayList<>();
        
        for (int i = num.length - 1; i >= 0; i--) {
            sum = num[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            ans.add(0, sum);
        }
        
        while (carry > 0) {
            ans.add(0, carry % 10);
            carry = carry / 10;
        }
        
        return ans;
    }
}
