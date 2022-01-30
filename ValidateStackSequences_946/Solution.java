class Solution {
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            
            // try to pop as many as you can
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        
        return stack.isEmpty();
    }
    
     public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < pushed.length; k++) {
            pushed[i] = pushed[k];
            i++;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                i--;
                j++;
            }
        }
        
        return i == 0;
    }
    
}
