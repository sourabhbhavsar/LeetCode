class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
           children = new TrieNode[26];
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] words = sentence.split("\\s+");
        StringBuilder ans = new StringBuilder();
        
        for (String word : words) {
            if (ans.length() > 0) {
                ans.append(" ");
            }
            
            TrieNode curr = root;
            for (char letter : word.toCharArray()) {
                if (curr.children[letter - 'a'] == null || curr.word != null) {
                    break;
                }
                
                curr = curr.children[letter - 'a'];
            }
            
            ans.append(curr.word != null ? curr.word : word);
        }
        
        return ans.toString();
    }
    
    TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
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
