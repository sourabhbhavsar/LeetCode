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
    private double maxSubtreeAvg = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        int[] sumAndCount = maximumAverageSubtreeHelper(root);
    
        int sum = sumAndCount[0];
        int count = sumAndCount[1];
        
        if (count != 0) {
            double avg = (double)sum / count;
            maxSubtreeAvg = Math.max(maxSubtreeAvg, avg);
        }
        
        
        return maxSubtreeAvg;
    }
    
    // return array 0 index is sum, 1 index is count of nodes
    public int[] maximumAverageSubtreeHelper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        
        if (root.left == null && root.right == null) {
            return new int[] {root.val, 1};
        }
        
        int[] left = maximumAverageSubtreeHelper(root.left);
        if (root.left != null) {
             maxSubtreeAvg = Math.max(maxSubtreeAvg, left[0] / left[1]);
        }
        
        int[] right = maximumAverageSubtreeHelper(root.right);
        if (root.right != null) {
             maxSubtreeAvg = Math.max(maxSubtreeAvg, right[0] / right[1]);
        }
        
        return new int[] {left[0] + root.val + right[0], left[1] + 1 + right[1]};
    }
}
