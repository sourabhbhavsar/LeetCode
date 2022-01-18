class Solution {
    public int minStickers(String[] stickers, String target) {
        if (target == null || target.length() == 0) {
            return 0;
        }
        
        if (stickers == null || stickers.length == 0) {
            return -1;
        }
        
        int m = stickers.length;
        int[][] stickersMap = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (char curr : stickers[i].toCharArray()) {
                stickersMap[i][curr - 'a']++;
            }
        }
        
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        
        return minStickersDP(stickersMap, target, memo);
    }
    
    public int minStickersDP(int[][] stickersMap, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int ans = Integer.MAX_VALUE;
        int m = stickersMap.length;
        int[] targetMap = new int[26];
        for (char curr : target.toCharArray()) {
            targetMap[curr - 'a']++;
        }
        
       
        for (int i = 0; i < m; i++) {
            // optimization
            if (stickersMap[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetMap[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetMap[j] - stickersMap[i][j]); k++) {
                        char c = (char)(j + 'a');
                        sb.append(c);
                    }
                }
            }
            
            // now that one sticker is applied
            int remaining = minStickersDP(stickersMap, sb.toString(), memo);
            if (remaining != -1) {
                ans = Math.min(ans, 1 + remaining);
            }
        }
        
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        
        memo.put(target, ans);
            
        return ans;
    }
     
}
