class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
            else {
                // keep poping the positive stars till they are smalle than this negative
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < (-1 * asteroids[i])) {
                    stack.pop();
                }
                
                // if its is equal just pop and done. Equal value cancels each other
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek()  == (-1 * asteroids[i])) {
                     stack.pop();
                }
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        
        int[] ans = new int[stack.size()];
        int index = 0;
        for (int n : stack) {
            ans[index] = n;
            index++;
        }
        
        return ans;
    }
}
