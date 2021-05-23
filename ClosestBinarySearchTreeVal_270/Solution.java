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
    private double leastDiffernce = Double.MAX_VALUE;
    private int closestNum = 0;
    
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        double diff = Math.abs(root.val - target);
        if (diff < leastDiffernce) {
            leastDiffernce = diff;
            closestNum = root.val;
        }
        
        if (root.left != null && root.val > target) {
            return closestValue(root.left, target);
        }
        
        if (root.right != null && root.val < target) {
            return closestValue(root.right, target);
        }
        
        return closestNum;
    }
}
