
class Solution {
    public double minAreaFreeRect(int[][] points) {
        if (points == null || points.length < 4) {
            return 0.0;
        }
        
        int len = points.length;
        double minArea = Double.MAX_VALUE;
    
        // key includes the length of the diagonal and the coordinate of the diagonal center
        // int[] is the index of two points forming the diagonal
        Map<String, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                // let p1 anf p2 be the end of diagonals
                
                // distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
                long distance = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                // centre point of diagonal
                double centreX = (double)(p1[0] + p2[0]) / 2.0;
                double centreY = (double)(p1[1] + p2[1]) / 2.0;
                
                String key = distance + "_" + centreX + "_" + centreY;
                
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                
                map.get(key).add(new int[]{i, j});
            }
        }
        
        // iterate over all the map entrie and see if we have enought point sto create recatnge
        for (String key : map.keySet()) {
            List<int[]> list = map.get(key);
            if (list.size() > 1) {
                // iterate over the points we have collected and calculate are formed by them
                
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        int pointIndex1 = list.get(i)[0];
                        int pointIndex2 = list.get(j)[0];
                        int pointIndex3 = list.get(j)[1];
                        
                        int[] p1 = points[pointIndex1];
                        int[] p2 = points[pointIndex2];
                        int[] p3 = points[pointIndex3];
                        
                        // p1 - p3 one side or rectangle
                        // p1 - p2 second side of rectangle.
                        
                        double p1p2 = Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
                        
                        double p1p3 = Math.sqrt((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]));
                        
                        System.out.println("a = " + p1p2 + " b = " + p1p3);
                        double area = p1p2 * p1p3;
                        
                        minArea = Math.min(minArea, area);
                    }
                }
                
            }  
        }
        
        if (minArea == Double.MAX_VALUE) {
            minArea = 0;
        }
        
        return minArea;
    }
}
