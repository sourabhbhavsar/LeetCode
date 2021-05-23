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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxDepth(root);
        
        return maxDiameter;
    }
    
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        
        maxDiameter = Math.max(maxDiameter, l + r); 
        
        int depth = Math.max(l, r);
        
        return depth + 1;
    }
}
