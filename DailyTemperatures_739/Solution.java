class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // current temperature is more than previous one
                int smaller = stack.pop();
                ans[smaller] = i - smaller;  
            }
            
            stack.push(i);
        }
        
        return ans;
    }
}
