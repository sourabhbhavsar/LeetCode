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
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return sortedListToBST(0, list.size() - 1);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root =  list.get(mid);
        root.left = sortedListToBST(start, mid - 1);
        root.right = sortedListToBST(mid + 1, end);
        
        return root;
    }
}
