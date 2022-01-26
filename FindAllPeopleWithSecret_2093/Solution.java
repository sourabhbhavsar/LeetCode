class Solution {
    class UnionFind {
        int[] parents;
        int n;
        
        UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        
        public void union(int p1, int p2) {
            int parentP1 = findParent(p1);
            int parentP2 = findParent(p2);
            parents[parentP2] = parentP1;
        }
        
        public boolean isConected(int p1, int p2) {
            int parentP1 = findParent(p1);
            int parentP2 = findParent(p2);
            return parentP1 == parentP2;
        }
        
        public int findParent(int p) {
            while (parents[p] != p) {
                p = parents[p];
            }
            
            return p;
        }
        
        public void reset(int p) {
            parents[p] = p;
        }
    }
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<Integer>> timeToMeetingIndicesMap = new TreeMap<>();
        int numMeetings = meetings.length;
        
        for (int i = 0; i  < numMeetings; i++) {
            int time = meetings[i][2];
            if (!timeToMeetingIndicesMap.containsKey(time)) {
                timeToMeetingIndicesMap.put(time, new ArrayList<>());
            }
            
            timeToMeetingIndicesMap.get(time).add(i);
        }
        
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        
        for (int time : timeToMeetingIndicesMap.keySet()) {
            Set<Integer> group = new HashSet<>();
            
            for (int i : timeToMeetingIndicesMap.get(time)) {
                int p1 = meetings[i][0];
                int p2 = meetings[i][1];
                
                uf.union(p1, p2);
                group.add(p1);
                group.add(p2);
            }
            
            for (int person : group) {
                if (!uf.isConected(person, 0)) {
                    uf.reset(person);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.isConected(i, 0)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}
