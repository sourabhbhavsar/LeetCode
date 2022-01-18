class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }        
        
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return level;
                }
                
                for (String neighbour : getNeighbours(curr, wordSet)) {
                    queue.offer(neighbour);
                }
            }
            
            level++;
        }
        
        // if endword not reached.
        return 0;
    }
    
    public List<String> getNeighbours(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] array = word.toCharArray();
            // replace each character by any other letter
            for (char c = 'a'; c <= 'z'; c++) {
                array[i] = c;
                String next = new String(array);
                
                if (wordSet.remove(next)) {
                    res.add(next);
                }
            }
        }
        
        return res;
    }
} 
