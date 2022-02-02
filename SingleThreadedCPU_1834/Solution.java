 class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {i, tasks[i][0], tasks[i][1]};
        }
        
        Arrays.sort(jobs, (a, b) -> (Integer.compare(a[1], b[1])));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
                                                        (a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]));
        
        int time = 0;
        int index = 0;
        int[] ans = new int[n];
        int jobIndex = 0;
        
        while (index < n) {
            while (jobIndex < n && time >= jobs[jobIndex][1]) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[jobIndex][1];
                continue;
            }
            
            int[] curr = pq.poll();
            ans[index++] = curr[0];
            time = time + curr[2];
        }
        
        return ans;
    }
}
