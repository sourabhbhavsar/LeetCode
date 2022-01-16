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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        return countSumTarget(root, targetSum, preSum, 0);
    }
    
    int countSumTarget(TreeNode root, int targetSum, Map<Integer, Integer> preSum, int currSum)  {
        if (root == null) {
            return 0;
        }
        
        // update the prefix sum by adding the current val
        currSum = currSum + root.val;
     
        // get the number of valid path, ended by the current node
        int numPathToCurr = 0;
        if (preSum.containsKey(currSum - targetSum)) {
            numPathToCurr = preSum.get(currSum - targetSum);
        }
        
         // update the map with the current sum, so the map is good to be passed to the next recursion
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        int ans = numPathToCurr + countSumTarget(root.left, targetSum, preSum, currSum) 
                                + countSumTarget(root.right, targetSum, preSum, currSum);
        
        // restore the map, as the recursion goes from the bottom to the top
        preSum.put(currSum, preSum.get(currSum) - 1);
        
        return ans;   
    }
}
