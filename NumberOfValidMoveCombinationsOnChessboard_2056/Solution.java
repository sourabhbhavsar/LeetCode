class Solution {
    // 0: rook, queen, bishop
    int[][][] dirs = { 
                        {{-1,0},{1,0},{0,-1},{0,1}},
		                {{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{-1,1},{1,-1}},
		                {{1,1},{-1,-1},{-1,1},{1,-1}}
                     };
    
    public int countCombinations(String[] pieces, int[][] positions) {
        List<int[]>[] allPositions = new List[positions.length];
        for (int i = 0; i < pieces.length; i++) {
            allPositions[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < pieces.length; i++) {
            // convert to 0 index base from given 1 based index.
            positions[i][0]--;
            positions[i][1]--;
            
            allPositions[i].add(positions[i]);
            int dirIndex = 0;
            switch (pieces[i]) {
                case "rook":
                    dirIndex = 0;
                    break;
                case "queen":
                    dirIndex = 1;
                    break;
                case "bishop":
                    dirIndex = 2;
                    break;
            }
            
            
            for (int[] dir : dirs[dirIndex]) {
                int r = positions[i][0];
                int c = positions[i][1];
                
                while (true) {
                    r = r + dir[0];
                    c = c + dir[1];
                    
                    if (r < 0 || r >= 8 || c < 0 || c >= 8) {
                        break;
                    }
                    
                    allPositions[i].add(new int[] {r, c});
                }
            }
        }
        
        int[] stopIndex = new int[pieces.length];
        return dfs(positions, allPositions, stopIndex, 0);
    }
    
    private int dfs(int[][] positions,  List<int[]>[] allPositions, int[] stopIndex, int curr) {
        if (curr == stopIndex.length) {
            int[][] initialPositions = new int[positions.length][2];
            
            for (int i = 0; i < initialPositions.length; i++) {
                initialPositions[i] = new int[] {positions[i][0], positions[i][1]};
            }
            
            return check(initialPositions, allPositions, stopIndex);
        }
        
        int ans = 0;
        for (int i = 0; i < allPositions[curr].size(); i++) {
            stopIndex[curr] = i;
            ans = ans + dfs(positions, allPositions, stopIndex, curr + 1);
        }
        
        return ans;
    }
    
    int check(int[][] positions, List<int[]>[] allPositions, int[] stopIndex) {
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = false;
            
            for (int i = 0; i < positions.length; i++) {
                int diff = allPositions[i].get(stopIndex[i])[0] - positions[i][0];
                if (diff > 0) {
                    positions[i][0]++;
                    keepGoing = true;
                }
                else if (diff < 0) {
                    positions[i][0]--;
                    keepGoing = true;
                }
                
                diff = allPositions[i].get(stopIndex[i])[1] - positions[i][1];
                if (diff > 0) {
                    positions[i][1]++;
                    keepGoing = true;
                }
                else if (diff < 0) {
                    positions[i][1]--;
                    keepGoing = true;
                }
            }
            
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < positions.length; i++) {
                String key = positions[i][0] + "_" + positions[i][1];
                if (seen.contains(key)) {
                    return 0;
                }
                
                seen.add(key);
            }
        }
        
        return 1;
    }
}
