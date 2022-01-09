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

// 8  7  6  5  4  3  2  1  0
// 8 15 21 26 30 33 35 36 36


class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        List<Integer> cummSum = new ArrayList<>();
        inOrder(root, cummSum);  
        
        int sum = 0;
        for (int i = cummSum.size() - 1; i >= 0; i--) {
            sum = sum + cummSum.get(i);
            cummSum.set(i, sum);
        }
        
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int index = 0;
        //System.out.println("cummSum = " + cummSum);
        
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            TreeNode node = stack.pop();
            //System.out.println(node.val);
            node.val = cummSum.get(index);
            index++;
            
            curr = node.right;
        }
        
        return root;
    }
    
    
    
    public void inOrder(TreeNode root, List<Integer> cummSum) {
        if (root == null) {
            return;
        }
        inOrder(root.left, cummSum);
        cummSum.add(root.val);
        inOrder(root.right, cummSum);
    }
    
}
