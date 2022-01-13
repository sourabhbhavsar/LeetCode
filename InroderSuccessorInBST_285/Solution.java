/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            }
            else {
                result = root;
                root = root.left;
            }
        }
        
        return result;
    }
    
    public TreeNode inorderPredecessor (TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while(root != null) {
            if(root.val < p.val) {
        	    pre = root;
        	    root = root.right;
            }
            else {
                root = root.left;
            } 
        }
        return pre;
    }
}
