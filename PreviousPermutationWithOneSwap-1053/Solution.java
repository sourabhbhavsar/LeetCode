class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int index = -1;
        
        // find the largest index such that  arr[i - 1] > arr[i]
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                index = i - 1;
                break;
            }
        }
        
        if (index == -1) {
            // it is sorted and we cant do much
            return arr;
        }        
        
        // find the largest j such that arr[j] < arr[index]
        for (int j = arr.length - 1; j > index; j--) {
            // second condition is to eliminate duplicates.
            if (arr[j] < arr[index] && arr[j] != arr[j - 1]) {
                int tmp = arr[j];
                arr[j] = arr[index];
                arr[index] = tmp;
                break;
            }
        }
        
        return arr;
    }
}
