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
        StringBuilder sb = new StringBuilder("");
        serializeHelper(root, sb);
        
        return sb.toString();
    }
    
    void serializeHelper(TreeNode root, StringBuilder data) {
        if (root == null) {
            data.append("X");
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
        String[] nodeArray = data.split(",");
        Queue<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(nodeArray));
        
        TreeNode root = buildTree(nodes);
        
        return root;
    }
    
    public TreeNode buildTree(Queue<String> nodes) {
        if (!nodes.isEmpty()) {
            String nodeVal = nodes.poll();
            
            if (nodeVal.equals("X")) {
                return null;
            }
            else {
                TreeNode node = new TreeNode(Integer.valueOf(nodeVal));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                
                return node;
            }
        }
        
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
