class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <=n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            k = k - index * factorial[n - i];
        }
        
        return sb.toString();
    }
}
