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
class Solution {
    public TreeNode str2tree(String s) {
        return buildTree(s);
    }
    
    public TreeNode buildTree(String s) {
        
        if (s == null || s.length() == 0) {
            return null;
        }
    
        int indexOfFirstOpenParenthesis = s.indexOf('(');
        if (indexOfFirstOpenParenthesis == -1) {
            TreeNode root = new TreeNode(Integer.valueOf(s));
            return root;      
        }
      
        String rootData = s.substring(0, indexOfFirstOpenParenthesis);
        String childrenStr = s.substring(indexOfFirstOpenParenthesis);
        //System.out.println("rootData = " + rootData + ", childrenStr = " + childrenStr);
        
        TreeNode root = new TreeNode(Integer.valueOf(rootData));
         
        
        if (childrenStr.indexOf("(") != -1) {
            List<String> children = unboxChildren(childrenStr);
            
            if (children.size() > 0)
            root.left = buildTree(children.get(0));
            root.right = buildTree(children.get(1));
        }
        
        return root;
    }
    
    public List<String> unboxChildren(String s) {
        
        int rightCount = 0;
        Stack<Character> stack = new Stack<>();
        List<String> children = new ArrayList<>();
       
        
        int leftCount = 1;
        int childIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(') {
                leftCount++;
            }
            else if (curr == ')') {
                rightCount++;
            }
            
            if (leftCount == rightCount) {
                String child = "";
                
                while (!stack.isEmpty()) {
                    child = stack.pop() + child;
                }
                
                children.add(child);
                // reset
                leftCount = 1;
                rightCount = 0;
                // skip 1 char
                i = i + 1;
                
            }
            else {
                stack.push(curr);
            }
        }
        
        if (children.size() < 2) {
            children.add("");
        }
        
         System.out.println(children);
        return children;
    }
}
