/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

// Time complexity: O(n) - we run on the entire tree once. Our map acts as memoization to prevent redoing work.
// Space copmlexity: O(n) - We're creating a hashmap to save all nodes in the tree.

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        
        Map<Node, NodeCopy> map = new HashMap();
        return copyRandomBinaryTreeHelper(root, map);
    }
    
    public NodeCopy copyRandomBinaryTreeHelper(Node root,  Map<Node, NodeCopy> map) {
        if (root == null) {
            return null;
        }
        
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);
        copy.left = copyRandomBinaryTreeHelper(root.left, map);
        copy.right = copyRandomBinaryTreeHelper(root.right, map);
        copy.random = copyRandomBinaryTreeHelper(root.random, map);
        
        return copy;
        
    }
    
}
