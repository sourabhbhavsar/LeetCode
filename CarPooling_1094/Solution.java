class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (Integer.compare(a[1], b[1])));
        
        // [0]->number of pasengers in trip, [1]->end km of the trop
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        
        int currentPassengers = 0;
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int numPassenger = trip[0];
            int to = trip[2];
            int start = trip[1];
            
            while (!pq.isEmpty() && pq.peek()[1] <= start) {
                int[] earliestEndingTrip = pq.poll();
                currentPassengers = currentPassengers - earliestEndingTrip[0];
            }
            
            if (currentPassengers + numPassenger > capacity) {
                return false;
            }
            
            currentPassengers = currentPassengers + numPassenger;
            pq.offer(new int[] {numPassenger, to});
        }
        
        return true;
    }
}
