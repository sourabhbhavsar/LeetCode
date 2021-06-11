class Solution {
    public String alienOrder(String[] words) {
        if(words==null || words.length==0) {
            return "";
        }
        
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
                
                indegree.put(c, 0);  
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            
            // In a valid alphabet, prefixes are always first
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                
                if (c1 != c2) {
                    Set<Character> set = graph.get(c1);
                    // IMP avoid counting same character as indegree.
                    if (!set.contains(c2)) {
                        set.add(c2);
                        
                        int deg = indegree.get(c2);
                        indegree.put(c2, deg + 1);
                    }
                    
                    break;
                }
            }
        }
               
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        
        for (Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            ans.append(curr);
       
            Set<Character> neighbours = graph.get(curr);
            for (char neighbour : neighbours) {
                int deg = indegree.get(neighbour);
                indegree.put(neighbour, deg - 1);
                
                if (deg == 1) {
                    queue.offer(neighbour);
                }
            }
            
            count++;
        }
        
        if (count != graph.size()) {
            return "";
        }
        
        return ans.toString();
    }
}
