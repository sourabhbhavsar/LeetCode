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
    
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        
        while (a != b) {
            if (a == null) {
                // swap (not p this time)
                a = q;
            }
            else{
                a = a.parent;
            }
            
            if (b == null) {
                b = p;
            }
            else {
                b = b.parent;
            }
        }
        
        return a;
    }
    
    public Node lowestCommonAncestor2(Node p, Node q) {
        List<Node> path = find_Path(p);
        while (q.parent != null) {
            for (Node node : path) {
                if (node == q) return q;
            }
            q = q.parent;
        }
        return q;
    }
    
    public List<Node> find_Path(Node p) {
        List<Node> path = new ArrayList<>();
        while (p.parent != null) {
            path.add(p);
            p = p.parent;
        }
        return path;
    }
    
}
