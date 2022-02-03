class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]});
            points.add(new int[] {building[1], building[2]});
        }
        
        Collections.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<Integer> heightQueue = new PriorityQueue<>(Collections.reverseOrder());
        // improvement TreeMap
        
        heightQueue.offer(0);
        int prevMax = 0;
        List<List<Integer>> skyline = new ArrayList<>();

        for (int[] point : points) {
            // start
            if (point[1] < 0) {
                heightQueue.offer(-point[1]);
                // improvement TreeMap frequency count
            }
            // end
            else {
                // remov the height from queue as it ended
                heightQueue.remove(point[1]);
            }
            
            int currMax = heightQueue.peek();
            if (currMax != prevMax) {
                skyline.add(Arrays.asList(point[0], currMax));
                prevMax = currMax;
            }
        }
           
        return skyline;
    }
}
