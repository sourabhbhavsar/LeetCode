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
    public int equalToDescendants(TreeNode root) {
        int[] ans = helper(root);
        return ans[1];
    }
    
    // return int[], [0] => sum of subtree rooted at this node,
    // [1] = count of nodes equal to sum of decendents.
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int sumOfDescendent = left[0] + right[0];
        
        if (sumOfDescendent == root.val) {
            return new int[] {sumOfDescendent + root.val, left[1] + right[1] + 1};
        }
        
        return new int[] {sumOfDescendent + root.val, left[1] + right[1]};
    }
}
