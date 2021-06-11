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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxLevelSum = Integer.MIN_VALUE;
        int level = -1;
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            currLevel++;
            
            int levelSum = 0;
            for (int i = 1; i <= levelSize; i++) {
                TreeNode curr = queue.poll();
                
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                
                levelSum = levelSum + curr.val;
            }
            
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                level = currLevel;
            }
        }
        
        return level;
    }
    
    
}
