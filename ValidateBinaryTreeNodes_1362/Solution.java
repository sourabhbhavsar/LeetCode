class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> childToParentMap = new HashMap<>();
        
        if (leftChild.length != n || rightChild.length != n || leftChild.length != rightChild.length) 
        {
            return false;
        }
        
        int[] indegree = new int[n];
        
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                
                // one node can only have one parent.
                if (indegree[leftChild[i]] > 1) {
                    return false;
                }
                
            }
            
             if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                
                // one node can only have one parent.
                if (indegree[rightChild[i]] > 1) {
                    return false;
                }
                
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
            {
                // only one root allowed
                if (root != -1) {
                    return false;
                }
                else {
                    root = i;
                }
            }
        }
        
        // no root?
        if (root == -1) {
            return false;
        }
        
        int numNodes = countNodes(leftChild, rightChild, root);
        
        return n == numNodes;
    }
    
    public int countNodes(int[] leftChild, int[] rightChild, int root) {
        if (root == -1) {
            return 0;
        }
        
        return 1 + countNodes(leftChild, rightChild, leftChild[root]) + countNodes(leftChild, rightChild, rightChild[root]) ;
    }
    
    
}
