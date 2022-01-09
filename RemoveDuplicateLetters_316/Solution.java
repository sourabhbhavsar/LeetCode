class Solution {
    public String removeDuplicateLetters(String s) {
        int[] occurences = new int[26];
        boolean[] selected = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        
        for (char c : str) {
            occurences[c - 'a']++;
        }
        
        for (char curr : str) {
            // decreases the occurece as we are processing this one
            occurences[curr - 'a']--;
            
            // this character is already selected then skip
            if (selected[curr - 'a']) {
                continue;
            }
            
            // pop and unvisit all the chars on stack top that are higher than curr
            // only if there are some occurences of them left to process.
            while (!stack.isEmpty() && stack.peek() > curr &&  occurences[stack.peek() - 'a'] != 0) {
                int index = stack.pop() - 'a';
                selected[index] = false;
            }
            
            stack.push(curr);
            selected[curr - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
