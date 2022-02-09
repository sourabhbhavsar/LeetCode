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
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
    
    // [0] -> not rob, [1] -> robbed
     public int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
         
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
         
         int[] res = new int[2];
         
         // if we are not robbing root, we have both options to rob or not rob root's child
         res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
         // if we are  robbing root, we have to not rob root's child
         res[1] = root.val + left[0] + right[0];
         
         return res;
    }
}
