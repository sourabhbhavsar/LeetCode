class TrieNode {
    public char key;
    public TrieNode[] children;
    public boolean isWord;
    
    public TrieNode(char key) {
        this.key = key;
        children = new TrieNode[26];
        isWord = false;
    }
}


class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            
            if (curr.children[key - 'a'] == null) {
                curr.children[key - 'a'] = new TrieNode(key);
            }
            
            curr = curr.children[key - 'a'];
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[] letters, int index, TrieNode root) {
        if (index == letters.length) {
            return root.isWord;
        }
        
        if (letters[index] != '.') {
            return (root.children[letters[index] - 'a'] != null && match(letters, 
                                                                     index + 1, 
                                                                     root.children[letters[index] - 'a'])) ;

        }
        else {
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null && match(letters, index + 1, root.children[i])) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
