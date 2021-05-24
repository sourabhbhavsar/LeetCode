/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    private int maxDiameter = 0;
    
    public int diameter(Node root) {
        height(root);
        return maxDiameter;
    }
    
      
    public int height(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        int maxHeight = 0;
        int secondMaxHeight = 0;
        
        for (Node child : root.children) {
            int currentHeight = height(child);
            
            if (currentHeight > maxHeight) {
                secondMaxHeight = maxHeight;
                maxHeight = currentHeight;
            }
            else if (currentHeight > secondMaxHeight) {
                secondMaxHeight = currentHeight;
            }
        }
    
        int distanceBetweenFarthestChildren = maxHeight + secondMaxHeight;
        maxDiameter = Math.max(maxDiameter, distanceBetweenFarthestChildren);
            
        return maxHeight + 1;
    }
}
