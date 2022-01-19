class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
       
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            // stack contains heights in increasing
			      // so, pop heights from stack until you see height >= your height
			      // because you cannot see persons after them
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                count++;
                stack.pop();
            }
            
            ans[i] = count + (stack.isEmpty() ? 0 : 1);
            stack.push(i);
        }
        
        return ans;
    }
}
