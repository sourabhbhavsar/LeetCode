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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        queue.offer(root);
        int turn = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                
                 if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            
            if (turn % 2 == 0) {
                ans.add(level);
            }
            else {
                Collections.reverse(level);
                ans.add(level);
            }
            turn++;
        }
        
        return ans;
    }
}
