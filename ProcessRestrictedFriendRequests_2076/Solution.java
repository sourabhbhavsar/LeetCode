class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        int[] parent = new int[n];
        boolean[] ans = new boolean[requests.length];
        Set<Integer>[] enemies= new Set[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            enemies[i] = new HashSet<>();
        }
        
        for (int[] restriction : restrictions) {
            int a = restriction[0];
            int b = restriction[1];
            enemies[a].add(b);
            enemies[b].add(a);
        }
        
        for (int i = 0; i < requests.length; i++) {
            int a = requests[i][0];
            int b = requests[i][1];
            
            int pa = findParent(parent, a);
            int pb = findParent(parent, b);
            
            if (pa == pb) {
                ans[i] = true;
            }
            else if(!enemies[pa].contains(pb) && !enemies[pb].contains(pa)) {
                //can merge. update personB's root to be person A
                parent[pb] = pa;
                // add all B's enemies to A's enemyies
                enemies[pa].addAll(enemies[pb]);
                
                // inform all B's enemies that A is a new enemy
                for (int e : enemies[pb]) {
                    enemies[e].add(pa);
                }
                
                ans[i] = true;
            }
            else {
                ans[i] = false;
            }
        }
        
        return ans;
    }
    
    int findParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        
        return i;
    }
}
