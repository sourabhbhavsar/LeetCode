/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int p = maxpathSumHelper(root);
        
        return Math.max(p, ans);
    }
    
    public int maxpathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = maxpathSumHelper(root.left);
        int r = maxpathSumHelper(root.right);
        
        // not including a negative subtree is better than incuding it.
        if (l < 0) {
            l = 0;
        }
        
        // not including a negative subtree is better than incuding it.
        if (r < 0) {
            r = 0;
        }
        // three options for path
        // option 1 : root, left
        // option 2 : root, right
        // option 3 : left, root, right
        int o1 = root.val + l;
        int o2 = root.val + r;
        int o3 = root.val + l + r;
   
        ans = Math.max(ans, o1);
        ans = Math.max(ans, o2);
        ans = Math.max(ans, o3);
        
        // pass the longest of option 1 or option 2 to the upper node.
        return Math.max(o1, o2);
    }
}
