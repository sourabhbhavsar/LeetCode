class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int previousEnd = intervals[0][1];
        
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (previousEnd > intervals[i][0]) {
                count++;
                //  Logic is that we sort by the first element in the intervals, then when we encounter an overlap, we increase the count, and decide to remove the interval with the larger end date
                previousEnd = Math.min(previousEnd, intervals[i][1]);
            }
            else {
                previousEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}
