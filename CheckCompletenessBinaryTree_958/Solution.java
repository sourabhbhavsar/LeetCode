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
 *     }x
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.peek() != null) {
            TreeNode curr = queue.poll();
            
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        
        // remove the leaf null pointers
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        
        // a complete binary tree should have no nodes in queue.
        return queue.isEmpty();
    }
    
   
}
