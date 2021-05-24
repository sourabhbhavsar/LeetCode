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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, Integer> distanceMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        findPathToTarget(root, target, distanceMap);
        
        distanceKHelper(root, k, distanceMap.get(root), ans, distanceMap);
        
        return ans;
    }
    
    // find the path from root to target node and their respective distance from target
    // eg: target will be 0 distance from target, target's parent will be 1 distance away from target
    // and so on up till the root
    int findPathToTarget(TreeNode root, TreeNode target, Map<TreeNode, Integer> distanceMap) {
        
        if (root == null) {
            return -1;
        }
        
        if (root.val == target.val) {
            // target is 0 distance away from target.
            distanceMap.put(target, 0);
                
            return 0;
        }
        
        int left = findPathToTarget(root.left, target, distanceMap);
        if (left >= 0) {
            distanceMap.put(root, left + 1);
            return left + 1;
        }
        
        int right = findPathToTarget(root.right, target, distanceMap);
        if (right >= 0) {
            distanceMap.put(root, right + 1);
            return right + 1;
        }
        
        return -1;
    }
    
    public void distanceKHelper(TreeNode root, int k, int distance, List<Integer> ans, Map<TreeNode, Integer> distanceMap) {
        if (root == null) {
            return;
        }
        
        // if this is in the path from root to target
        // then get it's distance from target. 
        if (distanceMap.containsKey(root)) {
            distance = distanceMap.get(root);
        }
        
        if (distance == k) {
            ans.add(root.val);
        }
        
        distanceKHelper(root.left, k, distance + 1, ans, distanceMap);
        distanceKHelper(root.right, k, distance + 1, ans, distanceMap);
    }
}
