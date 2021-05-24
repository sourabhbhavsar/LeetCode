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
   
    public int largestBSTSubtree(TreeNode root) {
        int[] ans = helper(root);
        
        return ans[2];
    }
    
    // returns {min, max, size of max BST under this root}
    public int[] helper(TreeNode root) {
        
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // if root is more than max in left and less then min of right
        if (root.val > left[1] && root.val < right[0]) {
           return new int[]{Math.min(root.val, left[0]), 
                            Math.max(root.val, right[1]), 
                            left[2] + right[2] + 1};
        }
        else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
