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

class Coordinate implements Comparable<Coordinate>{
    public Integer row;
    public Integer col;
    public Integer val;
    
    public Coordinate(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    public int compareTo(Coordinate that) {
        if (this.col != that.col) {
            return this.col.compareTo(that.col);
        }
        
        return 0;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Coordinate, List<Coordinate>> map = new TreeMap<>();
        
        verticalOrderHelper(root, map, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for (Coordinate key : map.keySet()) {
            List<Coordinate> list = map.get(key);
            Collections.sort(list, 
                             (Coordinate c1, Coordinate c2) ->c1.row.compareTo(c2.row));
            
            List<Integer> l = new ArrayList<>();
            for (Coordinate xy : list) {
                l.add(xy.val);
            }
            ans.add(l);
        }
        
        return ans;
    }
    
    public void verticalOrderHelper(TreeNode root, 
                                    Map<Coordinate, List<Coordinate>> map, 
                                    int row,
                                    int column) {
        if (root == null) {
            return;
        }
        
        verticalOrderHelper(root.left, map, row + 1, column - 1);
        // process node
        Coordinate xy = new Coordinate(row, column, root.val);
        if (map.containsKey(xy)) {
            List<Coordinate> list = map.get(xy);
            list.add(xy);
        }
        else {
            List<Coordinate> list = new ArrayList<>();
            list.add(xy);
            map.put(xy,list);
        }
        
        verticalOrderHelper(root.right, map, row + 1, column + 1);
    }
}
