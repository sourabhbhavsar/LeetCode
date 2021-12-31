class Cell {
    public int x;
    public int y;
    
    public Cell(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        
        int[][] ans = new int[m][n];
        
        Set<Cell> setA = new HashSet<>();
        Set<Cell> setB = new HashSet<>();
        
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                if (mat1[i][j] != 0) {
                    Cell cell = new Cell(i, j);
                    setA.add(cell);
                }
            }
        }
        
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                if (mat2[i][j] != 0) {
                    Cell cell = new Cell(i, j);
                    setB.add(cell);
                }
            }
        }
        
        for (Cell c1 : setA) {
            for (Cell c2 : setB) {
                if (c1.y == c2.x) {
                    ans[c1.x][c2.y] = ans[c1.x][c2.y] + mat1[c1.x][c1.y] * mat2[c2.x][c2.y];
                }
            }
        }
        
        return ans;
    }
}
