class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->(Integer.compare(i1[0], i2[0])));
        int count = 0;
        int lastEndTime = 0;
        
        for (int[] i : intervals) {
            if (lastEndTime <= i[0]) {
                count++;
                lastEndTime = Math.max(lastEndTime, i[1]);
            }
        }
        
        return count == intervals.length;
    }
}
