class Solution {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a, b) -> (Integer.compare(a[1], b[1])));
        
        int arrow = 0;
        int count = 0;
        for (int i = 0; i < segments.length; i++) {
            if (arrow == 0 || arrow < segments[i][0]) {
                arrow = segments[i][1];
                count++;
            }
        }
        
        return count;
    }
}
