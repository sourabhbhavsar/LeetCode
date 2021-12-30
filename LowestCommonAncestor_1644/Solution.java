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
    boolean pFound = false;
    boolean qFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        
        TreeNode lca = lcaHelper(root, p , q);
        
        if (pFound && qFound) {
            return lca;
        }
        
        return null;
    }
    
    public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = lcaHelper(root.left, p, q);
        TreeNode right = lcaHelper(root.right, p, q);
        
        if (root == p) {
            pFound = true;
            return root;
        }
        
        if (root == q) {
            qFound = true;
            return root;
        }
        
        if (left == null) {
            return right;
        }
        
        if (right == null) {
            return left;
        }
        
        return root;
    }
}
