/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return node;
        }
        
        if (node.right == null){
            Node curr = node;
            while (curr.parent != null && curr.parent.right == curr) {
                curr = curr.parent;
            }
            
            return curr.parent;
        }
        else {
            Node r = node.right;
            while (r.left != null) {
                r = r.left;
            }
            
            return r;
        }
    }
}
