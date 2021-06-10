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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        pathSumHelper(root, path, ans, targetSum);
        return ans;
    }
    
    private boolean pathSumHelper(TreeNode root, List<Integer> path, List<List<Integer>> ans, int targetSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                
                path.remove(path.size() - 1);
                return true;
            }
        }
        
        path.add(root.val);
        boolean leftPath = pathSumHelper(root.left, path, ans, targetSum - root.val);
        boolean rightPath = pathSumHelper(root.right, path, ans, targetSum - root.val);
        
        path.remove(path.size() - 1);
     
        return leftPath || rightPath;
    }
}
