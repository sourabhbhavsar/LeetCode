class Solution {
    class TreeNode {
        int val;
        int countGreaterOrEqual;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
            countGreaterOrEqual = 0;
        }
    }
    
    TreeNode construct(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, low, mid - 1);
        root.right = construct(nums, mid + 1, high);
        
        return root;
    }
    
    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        
        if (root.val == val) {
            root.countGreaterOrEqual++;
            return root;
        }
        else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        else {
            root.countGreaterOrEqual++;
            root.right = insert(root.right, val);
        }
        
        return root;
    }

    int search(TreeNode root, long val) {
        if (root == null) {
            return 0;
        }
        
        if (root.val == val) {
            return root.countGreaterOrEqual;
        }
        else if (val < root.val) {
            return root.countGreaterOrEqual + search(root.left, val);
        }
        else {
            return search(root.right, val);
        }
    }
    
    public int reversePairs(int[] nums) {
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        TreeNode root = construct(copy, 0, copy.length - 1);
        
        int count = 0;
        for (int n : nums) {
            count = count + search(root, 2L * n + 1);
            root = insert(root, n);
        }
        
        return count;
    }
}
