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
 */
class CBTInserter {
    List<TreeNode> tree;
    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        
        for (int i = 0; i < tree.size(); i++) {
            TreeNode curr = tree.get(i);
            if (curr.left != null) {
                tree.add(curr.left);
            }
            if (curr.right != null) {
                tree.add(curr.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        int numNodes = tree.size();
        TreeNode parent = tree.get((numNodes - 1) / 2);
        tree.add(node);
        // if the unumber of nodes is odd, thenwe add to left pointer, if even then to right
        if (numNodes % 2 == 1) {
            parent.left = node;
        }
        else {
            parent.right = node;
        }
        
        return parent.val;
    }
    
    public TreeNode get_root() {
        return tree.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
