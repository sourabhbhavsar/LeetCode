class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> out = new ArrayList<>();
        int[] lastIntervalAdded = newInterval;
        int begin = 0;
        int end = intervals.length;
        
        while (begin < end && intervals[begin][1] < newInterval[0]) {
            out.add(intervals[begin]);
            begin++;
        }
        
        while (begin < end && intervals[begin][0] <= newInterval[1]) {
            newInterval = new int[] {
                Math.min(intervals[begin][0], newInterval[0]),
                Math.max(intervals[begin][1], newInterval[1])
            };
            
            begin++;
        }
        
        out.add(newInterval);
        
        while (begin < end) {
            out.add(intervals[begin]);
            begin++;
        }
        
        int[][] ans = new int[out.size()][2];
        for (int i = 0; i < out.size(); i++) {
            ans[i] = out.get(i);
        }
        
        return ans;
    }
    
    public int[] getIntersection(int[] in1, int[] in2) {
        int[] intersection = new int[2];
        intersection[0] = Math.min(in1[0], in2[0]);
        intersection[1] = Math.max(in1[1], in2[1]);
        
        return intersection;
    }
    
    public boolean hasIntersection(int[] in1, int[] in2) {
        return (in1[0] >= in2[0] && in1[0] <= in2[1]) ||
                (in2[0] >= in1[0] && in2[0] <= in1[1]);
    }
}
