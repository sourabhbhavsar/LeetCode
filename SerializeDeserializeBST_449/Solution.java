/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder("");
        serializeHelper(root, data);
        
        return data.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder data) {
        if (root == null) {
            data.append("x");
            data.append(",");
            
            return;
        }
        
        data.append(root.val);
        data.append(",");
        
        serializeHelper(root.left, data);
        serializeHelper(root.right, data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(nodes));
        
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        
        String data = q.poll();
        
        if (data.equals("x")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(data));
        node.left = buildTree(q);
        node.right = buildTree(q);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
