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
    public int sumNumbers(TreeNode root) {
        
        return sumNumbersHelper(root, 0);
    }
    
    public int sumNumbersHelper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        
        int leftSum = sumNumbersHelper(root.left, currentSum);
        int rightSum = sumNumbersHelper(root.right, currentSum);
        
        return leftSum + rightSum;
    }
    
   
}
