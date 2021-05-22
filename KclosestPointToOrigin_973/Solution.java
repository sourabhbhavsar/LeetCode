class Point implements Comparable<Point>{
    public int x;
    public int y;
    
    public Point(int i, int j) {
        x = i;
        y = j;
    }
    
    public int compareTo(Point that) {
        if (this.getDistanceFromOrigin() < that.getDistanceFromOrigin()) {
            return -1;
        }
        else if (this.getDistanceFromOrigin() > that.getDistanceFromOrigin()){
            return 1;
        }
        
        return 0;
    }
    
    public double getDistanceFromOrigin() {
        double a = Math.pow(x, 2); 
        double b = Math.pow(y, 2); 
        
        return Math.sqrt(a + b);
    }
    
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pointHeap = new PriorityQueue<Point>();
        
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            pointHeap.add(p);
        }
        
        int ansLen = Math.min(k, points.length);
        int[][] ans = new int[ansLen][2];
        
        int index = 0;
        while (!pointHeap.isEmpty() && k > 0) {
            Point p = pointHeap.poll();
            
            ans[index] = new int[] {
                p.x,
                p.y
            };
    
            index++;
            k--;
        }
        
        return ans;
    }   
}
