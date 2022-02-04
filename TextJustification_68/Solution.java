class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        
        while (left < words.length) {
            right = findRight(words, left, maxWidth);
            String line = justify(left, right, words, maxWidth);
            ans.add(line);
            
            left = right + 1;
        }
        
        return ans;
    }
    
    int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int space = 1;
        int lineSize = words[right++].length();
        
        while (right < words.length && lineSize + space + words[right].length() <= maxWidth) {
            lineSize = lineSize + space + words[right].length();
            right++;
        }
        
        return right - 1;
    }
    
    String justify(int left, int right, String[] words, int maxWidth) {
        if (left == right) {
            return pad(words[left], maxWidth);
        }
        
        boolean isLastLine = right == words.length - 1;
        int numSpace = right - left;
        int totalSpace = maxWidth - wordsLength(words, left, right);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpace);
        int remainder = isLastLine ? 0 : totalSpace % numSpace;
        
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        }
        
        return pad(sb.toString().trim(), maxWidth);
    }
    
    int wordsLength(String[] words, int left, int right) {
        int length = 0;
        for (int i = left; i <= right; i++) {
            length = length + words[i].length();
        }
        
        return length;
    }
    
    String pad(String str, int maxWidth) {
        return str + blank(maxWidth - str.length());
    }
    
    String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
    
}
