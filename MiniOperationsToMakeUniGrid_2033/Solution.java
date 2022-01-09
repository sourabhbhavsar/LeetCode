class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] array = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[index++] = grid[i][j];
            }
        }
        
        Arrays.sort(array);
        //int k = (array.length - 1) / 2;
        //int median = quickSelect(array, 0, array.length - 1, k);
        int median = array[(array.length - 1) / 2];
        //System.out.println("median = " + median);
        
        int count  = 0;
        for (int num : array) {
            if (num == median) {
                continue;
            }
            
            if (Math.abs(num - median) % x != 0) {
                return -1;
            }
            
            count = count + Math.abs(num - median) / x;
        }
        
        return count;
    }
    
    int quickSelect(int[] array, int low, int high, int k) {
        int pivot = array[high];
        int p = low;
        
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                //swap i and p
                int t = array[i];
                array[i] = array[p];
                array[p] = t;
                p++;
            }
        }
        
        // swap p and array[high]
        int t = array[high];
        array[high] = array[p];
        array[p] = t;
        
        if (p > k) {
            return quickSelect(array, low, p - 1, k);
        }
        else if (p < k) {
            return quickSelect(array, p + 1, high, k);
        }
        else {
            return array[p];
        }
    }
}
