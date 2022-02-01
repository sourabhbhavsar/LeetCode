class Solution {
    public int numTrees(int n) {
        //dp[k] represents the number of BST trees built consecutive k numbers;
        int[] dp = new int[n + 1];
        dp[0] = 1; // null tree with 0 node.
        dp[1] = 1; // only one tree possible with singel root.
        
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root<= i; root++) {
                int left = dp[root - 1];
                int right = dp[i - root];
                
                dp[i] = dp[i] + left * right;
            }
        }
        
        return dp[n];
    }
}
