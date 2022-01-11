class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (deadendSet.contains(curr)) {
                    continue;
                }
                
                if (curr.equals(target)) {
                    return level;
                }
                
                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < 4; j++) {
                    char c = sb.charAt(j);
                    String c1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    String c2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    
                    if (!visited.contains(c1) && !deadendSet.contains(c1)) {
                        queue.offer(c1);
                        visited.add(c1);
                    }
                    
                    if (!visited.contains(c2) && !deadendSet.contains(c2)) {
                        queue.offer(c2);
                        visited.add(c2);
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}
