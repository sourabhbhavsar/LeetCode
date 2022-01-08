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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root, 0, root.val);
        
        return max;
    }
    
    public void helper(TreeNode root, int curr, int target) {
        if (root == null) {
            return;
        }
        
        if (root.val == target) {
            curr = curr + 1;
        }
        else {
            curr = 1;
        }
        
        max = Math.max(max, curr);
        
        helper(root.left, curr, root.val + 1);
        helper(root.right, curr, root.val + 1);
    }
}
