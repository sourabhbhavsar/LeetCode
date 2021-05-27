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
        
        HashMap<TreeNode, Integer> distMap = new HashMap<>();
        findPathFromRoot(root, k, distMap);
        
        for (TreeNode n : distMap.keySet()) {
            System.out.println("Node = " + n.val + " is at distance = " + distMap.get(n));
        }
        
        int minDistanceLeaf = 0;
        int minDistance = Integer.MAX_VALUE;
        
        for (TreeNode curr : distMap.keySet()) {
            int distanceFromTarget = distMap.get(curr);
            int[] distAndLeaf = closestLeafInSubtree(curr);
            
            if (minDistance > distAndLeaf[0] + distanceFromTarget) {
                minDistance = distAndLeaf[0] + distanceFromTarget;
                minDistanceLeaf = distAndLeaf[1];
            }
        }
        
        return minDistanceLeaf;
    }
    
    // result[0] distance, result[1] node.val
    private int[] closestLeafInSubtree(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MAX_VALUE, 0};
        }
        
        if (root.left == null && root.right == null) {
            return new int[] {0, root.val};
        }
        
        int[] left = closestLeafInSubtree(root.left);
        int[] right = closestLeafInSubtree(root.right);
        
        if (left[0] < right[0]) {
            return new int[] {left[0] + 1, left[1]};
        }
        
        return new int[] {right[0] + 1, right[1]};
    }
    
    private int findPathFromRoot(TreeNode root, int k, HashMap<TreeNode, Integer> distMap) {
        if (root == null) {
            return -1;
        }
        
        if (root.val == k) {
            distMap.put(root, 0);
            
            return 0;
        }
        
        int left = findPathFromRoot(root.left, k, distMap);
        
        if (left >= 0) {
            distMap.put(root, left + 1);
            return left + 1;
        }
        
        int right = findPathFromRoot(root.right, k, distMap);
        
        if (right >= 0) {
            distMap.put(root, right + 1);
            return right + 1;
        }
        
        return -1;
    }
}
