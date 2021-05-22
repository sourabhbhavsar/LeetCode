/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null) {
            return -1;
        }
        
        List<Integer> dimension = binaryMatrix.dimensions();
        int m = dimension.get(0);
        int n = dimension.get(1);
        
        int minColumn = Integer.MAX_VALUE;
        
        for (int i = 0; i < m; i++) {
            int oneIndex = findIndexOfOne(binaryMatrix, i, n);
            System.out.println("oneIndex = " + oneIndex + ", row = " + i);
            
            if (oneIndex != -1) {
                if (minColumn > oneIndex) {
                    minColumn = oneIndex;
                }
            }
        }
        
        if (minColumn == Integer.MAX_VALUE) {
            minColumn = -1;
        }
        return minColumn;
    }
    
    public int findIndexOfOne(BinaryMatrix binaryMatrix, int row, int n) {
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int numAtMid = binaryMatrix.get(row, mid);
            
            if (numAtMid == 1 && (mid == 0 || binaryMatrix.get(row, mid - 1) == 0)) {
                return mid;
            }
            else if (numAtMid == 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
