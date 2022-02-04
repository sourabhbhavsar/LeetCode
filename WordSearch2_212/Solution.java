class Solution {
    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
    
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
    
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(board, root.children[board[i][j] - 'a'], visited, m, n, i, j, ans);    
                }
            }
        }
        
        return ans;
    }

    
    void dfs(char[][] board, TrieNode root, boolean[][] visited, int m, int n, int i, int j, List<String> ans) {
    
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
            
        visited[i][j] = true;
        for (int d = 0; d < dirs.length; d++) {
            int nx = i + dirs[d][0];
            int ny = j + dirs[d][1];
            
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && root.children[board[nx][ny] - 'a'] != null) {
                dfs(board, root.children[board[nx][ny] - 'a'], visited, m, n, nx, ny, ans);
            }
        }
        visited[i][j] = false;
    }
    
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                
                curr = curr.children[c - 'a'];
            }
            
            curr.word = word;
        }
        
        return root;
    }
}
