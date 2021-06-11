class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> pointMap = new HashMap<>();
        
        for (int[] p : points) {
            if (!pointMap.containsKey(p[0])) {
                pointMap.put(p[0], new HashSet<>());
            }
            
            pointMap.get(p[0]).add(p[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                //  // if have the same x or y
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                
                // if p1 and p2 are diagonal points then
                // their x and y coordinates will be swapped.
                if (pointMap.get(p1[0]).contains(p2[1]) && pointMap.get(p2[0]).contains(p1[1])) {
                    int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
                    minArea = Math.min(minArea, area);
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
