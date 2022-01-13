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
    int preIndex = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inOrder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inOrder);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
    
        return toBST(preorder, 0, inOrder.length, indexMap);
    }
    
    public TreeNode toBST(int[] preorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        
        if (inorderStart == inorderEnd) {
            return null;
        }
        
        int rootData = preorder[preIndex];
        TreeNode root = new TreeNode(rootData);
        int inorderIndex = indexMap.get(rootData);
        preIndex++;
        
        root.left = toBST(preorder, inorderStart, inorderIndex, indexMap);
        root.right = toBST(preorder, inorderIndex + 1, inorderEnd, indexMap);
        
        return root;
    }
}
