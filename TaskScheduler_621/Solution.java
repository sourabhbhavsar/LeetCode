class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int maxFrequency = 0;
        int countF = 0;
        
        for (char key : map.keySet()) {
            int f = map.get(key);
            
            if (f > maxFrequency) {
                maxFrequency = f;
                countF = 1;
            }
            else if (f == maxFrequency) {
                countF++;
            }
        }
        
        // System.out.println("maxFrequency = " + maxFrequency);
        // System.out.println("countF = " + countF);
        int numParts = maxFrequency - 1;
        int partLen = n - (countF - 1);
        int emptySlots = numParts * partLen;
        int numRestOfTasks = tasks.length - maxFrequency * countF;
        int idleCount = Math.max(0, emptySlots - numRestOfTasks);
        
        return tasks.length + idleCount;
    }
}
