class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                
                List<Integer> p1 = diffWaysToCompute(part1);
                List<Integer> p2 = diffWaysToCompute(part2);
                
                for (int i1 : p1) {
                    for (int i2 : p2) {
                        int val = 0;
                        if (expression.charAt(i) == '+') {
                            val = i1 + i2;
                        }
                        else if (expression.charAt(i) == '-') {
                            val = i1 - i2;
                        }
                        else if (expression.charAt(i) == '*') {
                            val = i1 * i2;
                        }
                        
                        ans.add(val);
                    }
                }
            }
        }
        
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }
        
        return ans;
    }
}
