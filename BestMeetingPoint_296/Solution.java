class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        
        int medianRow = rows.get(rows.size() / 2);
        int medianCol = cols.get(cols.size() / 2);
        
        int distance = 0;
        for (int i = 0; i < rows.size(); i++) {
            distance = distance + Math.abs(rows.get(i) - medianRow);
        }
        
        for (int i = 0; i < cols.size(); i++) {
            distance = distance + Math.abs(cols.get(i) - medianCol);
        }
        
        return distance;
    }
}
