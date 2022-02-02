class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> mismatchedIndices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                mismatchedIndices.push(i);
            }
            else {
                if (!mismatchedIndices.isEmpty() && s.charAt(mismatchedIndices.peek()) == '(') {
                    mismatchedIndices.pop();
                }
                else {
                    mismatchedIndices.push(i);
                }
            }
        }
        
        if (mismatchedIndices.isEmpty()) {
            return s.length();
        }
        
        int end = s.length();
        int maxLen = 0;
        while (!mismatchedIndices.isEmpty()) {
            int mismatchedIndex = mismatchedIndices.pop();
            int len = end - mismatchedIndex - 1;
            maxLen = Math.max(maxLen, len);
            
            end = mismatchedIndex;
        }
        maxLen = Math.max(maxLen, end);
        
        return maxLen;
    }
}
