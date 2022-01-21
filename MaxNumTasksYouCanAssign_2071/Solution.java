class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (canDoTasks(tasks, workers, pills, strength, mid)) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (canDoTasks(tasks, workers, pills, strength, high)) {
            return high;
        }
            
        return low;
    }
    
    public boolean canDoTasks(int[] tasks, int[] workers, int pills, int strength, int count) {
        Deque<Integer> queue = new ArrayDeque<>();
        int index = workers.length - 1;
        for (int j = count - 1; j >= 0; j--) {
            while (index >= workers.length - count && workers[index] + strength >= tasks[j]) {
                queue.offerFirst(workers[index]);
                index--;
            }
                
            if (queue.isEmpty()) {
                return false;
            }
                
            if (queue.peekLast() >= tasks[j]) { // strongest worker w/o pill
                queue.pollLast();
            }
            else {
                if (pills == 0) { // weakest worker that can do w/ pill
                    return false;
                }
                    
                pills--;
                queue.pollFirst();
            }
        }
     
        return true;
    }
}
