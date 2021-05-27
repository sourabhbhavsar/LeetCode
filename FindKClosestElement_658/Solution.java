class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] + arr[mid + k] - 2 * x >= 0) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        
        return Arrays.stream(arr, low, low + k)
            .boxed()
            .collect(Collectors.toList());
    }
}
