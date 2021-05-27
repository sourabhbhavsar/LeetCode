class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        int meetingRoomAvailable = 0;
        int minMeetingsRoomRequired = 0;
        
        Arrays.sort(intervals, (int[] i1, 
                                int[] i2) -> (i1[0] - i2[0]));
        
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (heap.isEmpty() || heap.peek() > start) {
                minMeetingsRoomRequired++;
                heap.offer(end);
            }
            else {
                int earliestEnd = heap.poll();
                int maxEnd = Math.max(earliestEnd, end);
                heap.offer(maxEnd);
            }
        }
        
        return minMeetingsRoomRequired;
    }
}
