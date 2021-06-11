class Solution {
    public int countComponents(int n, int[][] edges) {
        // roots of all set elements.
        int[] roots = new int[n];
        int numSets = n;
        
        // initially, all the set elements are in a set of itself
        // and has itself as a root.
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            
            // if the ends of this edge is in different sets
            // then union the two sets.
            if (root1 != root2) {
                roots[root1] = root2;
                
                // number of sets is reduced by 1.
                numSets--;
            }
        }
        
        return numSets;
    }
    
    public int findRoot(int[] roots, int id) {
        while (roots[id] != id) {
            id = roots[id];
        }
        
        return id;
    }
}
