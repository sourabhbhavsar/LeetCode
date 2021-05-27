/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        connectDFS(root.left, root.right);
        
        return root;
    }
    
    private void connectDFS(Node left, Node right) {
        // if no left then nothing to connect.
        if (left == null) {
            return;
        }
        
        // connect left's next to right.
        left.next = right;
        
        // connect the left subtree.
        connectDFS(left.left, left.right);
        
         // connect the right subtree.
        connectDFS(right.left, right.right);
        
        // connect right of left node to left of right node.
        connectDFS(left.right, right.left);
    }
    
    public Node connectBFS(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                
                if (i < size - 1) {
                    curr.next = queue.peek();
                }
                else {
                    curr.next = null;
                }
            }
        }
        
        return root;
    }
}
