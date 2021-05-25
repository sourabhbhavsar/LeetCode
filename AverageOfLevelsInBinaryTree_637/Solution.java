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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> out = new ArrayList<>();
        
        if (root == null) {
            return out;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double sum = 0;
            
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                
                sum = sum + curr.val;
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            
            if (levelSize != 0) {
                out.add(sum / levelSize);
            }
        }
        
        return out;
    }
}
