// 1,3,4,14
// 1,3,7,14

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        
        int nodeCount = 1;
        int level = 1;
        
        while (label >= 2 * nodeCount) {
            nodeCount = 2 * nodeCount;
            level++;
        }
        
        while (label != 0) {
            ans.add(0, label);
            int maxLabel = (int)Math.pow(2, level) - 1;
            int minLabel = (int)Math.pow(2, level - 1);
            
            int switchedLabel = (maxLabel - label) + minLabel;
            label = switchedLabel / 2;
            level--;
        }
        
        return ans;
    }
}
