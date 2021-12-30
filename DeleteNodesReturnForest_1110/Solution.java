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
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList();
        set = new HashSet<>();
        
        for (int n : to_delete) {
            set.add(n);
        }
        
        TreeNode node = delNodeshelper(root, true);
        return res;
    }
    
    public TreeNode delNodeshelper(TreeNode root, boolean isRoot) {
        if (root == null) {
            return null;
        }
        
        boolean isDeleted = false;
        if (set.contains(root.val)) {
            isDeleted = true;
        }
        
        if (isRoot && !isDeleted) {
            res.add(root);
        }
        
        root.left = delNodeshelper(root.left, isDeleted);
        root.right = delNodeshelper(root.right, isDeleted);
        
        if (isDeleted) {
            return null;
        }
        
        return root;
    }
}
