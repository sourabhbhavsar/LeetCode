class UnionFind {
    int[] setSize;
    int[] parent;
    
    public UnionFind(int size) {
        setSize = new int[size];
        parent = new int[size];
        
        for (int i = 0; i < size; i++) {
            // each index is a paent of itself
            parent[i] = i;
            // each set is of size 1 (itself)
            setSize[i] = 1;
        }
    }
    
    int findParent(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        
        return p;
    }
    
    int union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        
        if (parentA == parentB) {
            return setSize[parentA];
        }
        
        // merge smaller set to a bigger set
        if (setSize[parentA] > setSize[parentB]) {
            parent[parentB] = parentA;
            setSize[parentA] = setSize[parentA] + setSize[parentB];
            
            return setSize[parentA];
        }
        else {
            parent[parentA] = parentB;
            setSize[parentB] = setSize[parentB] + setSize[parentA];
            
            return setSize[parentB];
        }
    }
    
}


class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        
        for (List<Integer> indexPair : pairs) {
            uf.union(indexPair.get(0), indexPair.get(1));
        }
        
        Map<Integer, PriorityQueue<Character>> graph = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int parent = uf.findParent(i);
            if (!graph.containsKey(parent)) {
                graph.put(parent, new PriorityQueue<>());
            }
            
            graph.get(parent).offer(curr);
            
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int parent = uf.findParent(i);
            ans.append(graph.get(parent).poll());
        }
        
        return ans.toString();
    }
}
