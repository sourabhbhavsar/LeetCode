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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        ans.add(root.val);
        leftBoundary(root.left, ans);
        leaves(root.left, ans);
        leaves(root.right, ans);
        rightBoundary(root.right, ans);
        
        return ans;
    }
    
    void leftBoundary(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        
        ans.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right, ans);
        }
        else {
            leftBoundary(root.left, ans);
        }
    }
    
    void rightBoundary(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
    
        if (root.right == null) {
            rightBoundary(root.left, ans);
        }
        else {
            rightBoundary(root.right, ans);
        }
        
        ans.add(root.val); // add after child visit(reverse)
    }
    
    void leaves(TreeNode root, List<Integer> ans) { 
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
        
        leaves(root.left, ans);
        leaves(root.right, ans);
    }
}
