class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        wordSet.add(beginWord);

        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        
        if (!wordSet.contains(endWord)) {
            return ans;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);
        visited.add(beginWord);
        
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDistance = distances.get(curr);
        
                for (String neighbour : getNeighbours(curr, wordSet)) {
                    graph.get(curr).add(neighbour);
                    if (!distances.containsKey(neighbour)) {
                        distances.put(neighbour, currDistance + 1);
                        if (neighbour.equals(endWord)) {
                            foundEnd = true;
                        }
                        else {
                            queue.offer(neighbour);
                        }
                    }
                }
            }
            level++;
            if (foundEnd) {
                break;
            }
        }
        
        //System.out.println(graph);
        
        dfs(beginWord, endWord, graph, distances, new ArrayList<>(), ans);
        return ans;
    }
    
    private void dfs(String curr,
                     String end, 
                     Map<String, List<String>> graph,
                     Map<String, Integer> distances, 
                     List<String> list, 
                     List<List<String>> ans) {
        list.add(curr);
        if (curr.equals(end)) {
            ans.add(new ArrayList<>(list));
        }
        else {
            for (String next : graph.get(curr)) {
                if (distances.get(next) == distances.get(curr) + 1) {
                    dfs(next, end, graph, distances, list, ans);
                }
            }
        }
        
        list.remove(list.size() - 1);
    }

    
     public List<String> getNeighbours(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] array = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == c) {
                    continue;
                }
                
                char old = array[i];
                array[i] = c;
                String next = new String(array);
                if (wordSet.contains(next)) {
                    res.add(next);
                }
                array[i] = old;
            }
        }
        
        return res;
    }
}
