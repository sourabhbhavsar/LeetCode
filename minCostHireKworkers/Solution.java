class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }
        
        Arrays.sort(workers, (Worker w1, Worker w2) -> Double.compare(w1.rate, w2.rate));
        // System.out.println(Arrays.toString(workers));
        PriorityQueue<Worker> pool = new PriorityQueue<>((Worker w1, Worker w2) -> Integer.compare(w2.quality, w1.quality));
        
        int sumQuality = 0;
        double minCost = Double.MAX_VALUE;
        for (Worker worker : workers) {
            pool.offer(worker);
            sumQuality = sumQuality + worker.quality;
            
            if (pool.size() > k) {
                // kick out the one with maximum quality
                Worker highestQualityWorkerInGroup = pool.poll();
                sumQuality = sumQuality - highestQualityWorkerInGroup.quality;
            }
            
            if (pool.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker.rate);
            }
        }
        
        return minCost;
    }
    
}

class Worker {
    public int wage;
    public int quality;
    public double rate;
        
    public Worker(int wage, int quality) {
        this.wage = wage;
        this.quality = quality;
        this.rate = (double)wage / quality;
    }
    
    public String toString() {
        return "Worker[wage = " + wage + ", quality = " + quality + ", rate = " + rate + "]";
    }
}
