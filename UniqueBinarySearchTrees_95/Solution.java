/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 

    Time complexity : The main computations are to construct all possible trees with a given root, that is actually Catalan number GnG_nGn​ as was discussed above. This is done n times, that results in time complexity nGnn G_nnGn​. Catalan numbers grow as 4nn3/2\frac{4^n}{n^{3/2}}n3/24n​ that gives the final complexity O(4nn1/2)\mathcal{O}(\frac{4^n}{n^{1/2}})O(n1/24n​). Seems to be large but let's not forget that here we're asked to generate Gn∼4nn3/2G_n \sim \frac{4^n}{n^{3/2}}Gn​∼n3/24n​ tree objects as output.

    Space complexity : nGnn G_nnGn​ as we keep GnG_nGn​ trees with n elements each, that results in O(4nn1/2)\mathcal{O}(\frac{4^n}{n^{1/2}})O(n1/24n​) complexity.

 
 
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        
        List<TreeNode> trees = generateTreeHelper(1, n);
        
        return trees;
    }
    
    List<TreeNode> generateTreeHelper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        
        if (start > end) {
            trees.add(null);
        }
        else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubtrees = generateTreeHelper(start, i - 1);
                List<TreeNode> rightSubtrees = generateTreeHelper(i + 1, end);
                
                for (TreeNode left : leftSubtrees) {
                    for (TreeNode right : rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        
                        root.left = left;
                        root.right = right;
                        
                        trees.add(root);
                    }
                }
            }
        }
        
        return trees;
    }
}
