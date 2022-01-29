class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int a = flight[0];
            int b = flight[1];
            int cost = flight[2];
            
            graph.get(a).add(new int[] {b, cost});
        }
        
        int[] distances = new int[n];
        int[] leastStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(leastStops, Integer.MAX_VALUE);
        
        // int[] = [0]->node, [1]->cost, [2]->stops
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> (i1[1] - i2[1]));
        pq.offer(new int[] {src, 0, 0});

        distances[src] = 0;
        leastStops[src] = 0;
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curr = node[0];
            int cost = node[1];
            int stops = node[2];
            
            if (curr == dst) {
                return cost;
            }
            
            if (stops > k) {
                continue;
            }
            
            for (int[] neighbour : graph.get(curr)) {
                int ne = neighbour[0];
                int c = neighbour[1];
                
                if (distances[ne] > cost + c) {
                    distances[ne] = cost + c;
                    
                    pq.offer(new int[] {ne, cost + c, stops + 1});
                }
                else if (stops  < leastStops[ne]) {
                    pq.offer(new int[] {ne, cost + c, stops + 1});
                }
                
                leastStops[ne] = stops;
            }
        }
        
        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }
}
