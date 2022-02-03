class Solution {
    class Trie {
        int wordEnding = -1;
        List<Integer> palindromePrefixRemaining = new ArrayList<>();
        Trie[] children = new Trie[26];
    }
    
     public List<List<Integer>> palindromePairs(String[] words) { 
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
         
        int n = words.length;
        Trie root = new Trie();
         
        for (int i = 0; i < n; i++) {
            String word = words[i];
            String reverse = new StringBuilder(word).reverse().toString();
            Trie curr = root;
            for (int j = 0; j < reverse.length(); j++) {
                
                char ch = reverse.charAt(j);
                if (isPalindromeFrom(reverse, j)) {
                    curr.palindromePrefixRemaining.add(i);
                }
                
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Trie();
                }
                
                curr = curr.children[ch - 'a'];
            }
            
            curr.wordEnding = i;
        }
         
        for (int i = 0; i < n; i++) {
            String word = words[i];
            Trie curr = root;
            
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                
                // if there is a word ending here and the rest of the words formed after this node are palindromes?
                if (curr.wordEnding != -1 && isPalindromeFrom(word, j)) {
                    ans.add(Arrays.asList(i, curr.wordEnding));
                }
                
                curr = curr.children[ch - 'a'];
                if (curr == null) {
                    break;
                }
            }
            
            if (curr == null) {
                continue; // to next word
            }
            
            if (curr.wordEnding != -1 && curr.wordEnding != i) {
                ans.add(Arrays.asList(i, curr.wordEnding));
            }
            
            for (int prefixPalindromes : curr.palindromePrefixRemaining) {
                ans.add(Arrays.asList(i, prefixPalindromes));
            }
        }
         
        return ans;
     }
    
    public boolean isPalindromeFrom(String str, int i) {
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }    
    
    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
        
        Map<String, Integer> wordIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordIndex.put(words[i], i);
        }
        
        // case 1: a "" string can be appended with any palindromic string to form an ans pair.
        if (wordIndex.containsKey("")) {
            int i = wordIndex.get("");
            for (int j = 0; j < words.length; j++) {
                if (j != i && isPalindrom(words[j])) {
                    ans.add(Arrays.asList(i, j));
                    ans.add(Arrays.asList(j, i));
                }
            }
        }
        
        // case 2: if string a is reverse of string b
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            if (wordIndex.containsKey(rev)) {
                int j = wordIndex.get(rev);
                if (i != j) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        
        // case 3: if a substring of s1 from 0 to k is plaindrome and k to end is reverse of another word
        for (int i = 0; i < words.length; i++) { 
            String w1 = words[i];
            for (int k  = 1; k < w1.length(); k++) {
                if (isPalindrom(w1.substring(0, k))) {
                    String rev = new StringBuilder(w1.substring(k)).reverse().toString();
                    if (wordIndex.containsKey(rev)) {
                        int j = wordIndex.get(rev);
                        if (i != j) {
                            ans.add(Arrays.asList(j, i));
                        }
                    }
                }
                
                if (isPalindrom(w1.substring(k))) {
                    String rev = new StringBuilder(w1.substring(0, k)).reverse().toString();
                    if (wordIndex.containsKey(rev)) {
                        int j = wordIndex.get(rev);
                        if (i != j) {
                            ans.add(Arrays.asList(i, j));
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrom(String str) {
        int low = 0;
        int high = str.length() - 1;
        
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            
            low++;
            high--;
        }
        
        return true;
    }
}
