class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length < n - 1) {
            return -1;
        }
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;
        for (int[] edge : connections) {
            int p1 = findParent(edge[0], parent);
            int p2 = findParent(edge[1], parent);
            
            if (p1 != p2) {
                parent[p2] = p1;
                components--;
            }
        }
        
        return components - 1;
    }
    
    int findParent(int i, int[] parent) {
        while (parent[i] != i) {
            i = parent[i];
        }
        
        return i; 
    }
    
}
