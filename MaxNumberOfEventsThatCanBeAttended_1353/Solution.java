class Solution {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) {
            return 0;
        }
        
        Arrays.sort(events, (e1, e2)->(Integer.compare(e1[0], e2[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        int index = 0;
        int maxEndTime = 0;
        
        for (int[] event : events) {
            maxEndTime = Math.max(maxEndTime, event[1]);
        }
        
        for (int d = 1; d <= maxEndTime; d++) {
            
            // remove all events that ended in the past i.e end < d
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            
            // add all events that start at d
            while (index < events.length && events[index][0] == d) {
                pq.offer(events[index][1]); // only end time.
                index++;
            }
            
            // attend the one that ends the earliest of all that started today
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        
        return count;
    }
}
