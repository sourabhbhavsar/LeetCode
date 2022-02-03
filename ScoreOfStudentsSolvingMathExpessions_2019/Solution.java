class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int correct = evaluate(s);
        
        int n = s.length();
        Set<Integer>[][] dp = new Set[n][n];
        for (int i = 0; i < n; i = i + 2) {
            dp[i][i] = new HashSet<>();
            dp[i][i].add(s.charAt(i) - '0');
            
        }
        
        for (int end = 2; end < n; end = end + 2) {
            for (int start = end - 2; start >= 0; start = start - 2) {
                dp[start][end] = new HashSet<>();
                for (int k = start; k < end; k = k + 2) {
                    for (int left : dp[start][k]) {
                        for (int right : dp[k + 2][end]) {
                            int val = 0;
                            if (s.charAt(k + 1) == '+') {
                                val = left + right;
                            }
                            else {
                                val = left * right;
                            }
                            
                            if (val <= 1000) {
                                dp[start][end].add(val);
                            }
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int ans : answers) {
            if (ans == correct) {
                sum = sum + 5;
            }
            else if (dp[0][n - 1].contains(ans)) {
                sum = sum + 2;
            }
        }
        
        return sum;
    }
    
    int evaluate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)) {
                val = val * 10 + (curr - '0');
            }
            
            if (!Character.isDigit(curr) || i == s.length() - 1) {
                switch (lastSign) {
                    case '+':
                        stack.push(val);
                        break;
                    case '*':
                        int op1 = stack.pop();
                        int product = op1 * val;
                        stack.push(product);
                        break;
                }
                
                lastSign = curr;
                val = 0;
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + stack.pop();
        }
        
        return sum;
    }
    
    int misEvaluate(String s) {
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        char lastSign = '*';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)) {
                val = val * 10 + (curr - '0');
            }
            
            if (!Character.isDigit(curr) || i == s.length() - 1) {
                switch (lastSign) {
                    case '+':
                        int op1 = stack.pop();
                        int add = op1 + val;
                        stack.push(add);
                        break;
                    case '*':
                        stack.push(val);
                        break;
                }
                
                lastSign = curr;
                val = 0;
            }
        }
        
        int product = 1;
        while (!stack.isEmpty()) {
            product = product * stack.pop();
        }
        
        return product;
    }
}
