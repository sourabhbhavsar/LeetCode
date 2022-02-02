class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] nearestSmallerLeft = new int[n];
        Arrays.fill(nearestSmallerLeft, - 1);
        
        int[] nearestSmallerRight = new int[n];
        Arrays.fill(nearestSmallerRight, n);
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nearestSmallerRight[stack.pop()] = i;
            }
            
            stack.push(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nearestSmallerLeft[stack.pop()] = i;
            }
            
            stack.push(i);
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nearestSmallerRight[i] - nearestSmallerLeft[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
}
