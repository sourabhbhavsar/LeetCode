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
    private int maxDiff = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffHelper(root);
        
        return maxDiff;
    }
    
    public int[] maxAncestorDiffHelper(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        if (root.left == null & root.right == null) {
            return new int[] {root.val, root.val};
        }
        
        int[] left  = maxAncestorDiffHelper(root.left);
        int[] right = maxAncestorDiffHelper(root.right);
        

        int minSubtree = Math.min(right[0], left[0]);
        int maxSubtree = Math.max(right[1], left[1]);
        
        // for left subtree including root
        maxDiff = Math.max(maxDiff, Math.abs(root.val - minSubtree));
        maxDiff = Math.max(maxDiff, Math.abs(root.val - maxSubtree));
        
      
        int min = Math.min(root.val, left[0]);
        min = Math.min(min, right[0]);
        
        int max = Math.max(root.val, left[1]);
        max = Math.max(max, right[1]);
        
        return new int[] {min, max};
    }
    
}
