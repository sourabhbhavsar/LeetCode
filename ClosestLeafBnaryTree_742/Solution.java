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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> edges = new HashMap<>();
        TreeNode kNode = dfs(root, k, edges);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>(); 
        queue.offer(kNode);
        visited.add(kNode);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }
            
            if (curr.left != null && visited.add(curr.left)) {
                queue.offer(curr.left);
            }
            
            if (curr.right != null && visited.add(curr.right)) {
                queue.offer(curr.right);
            }
            
            if (edges.containsKey(curr) && visited.add(edges.get(curr))) {
                queue.offer(edges.get(curr));
            }
        }
        
        return -1;
    }
    
    public TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> egdes) {
        if (root == null) {
            return null;
        }
        
        if (root.val == k) {
            return root;
        }
        
        if (root.left != null) {
            egdes.put(root.left, root);
            TreeNode left = dfs(root.left, k, egdes);
            
            if (left != null) {
                return left;
            }
        }
        
        if (root.right != null) {
            egdes.put(root.right, root);
            TreeNode right = dfs(root.right, k, egdes);
            
            if (right != null) {
                return right;
            }
        }
        
        return null;
    }
}
