/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            sum = sum + depthSumHelper(ni, 1);
        }
        
        return sum;
    }
    
    public int depthSumHelper(NestedInteger nestedInt, int depth) {
        int sum = 0;
        
        if (nestedInt.isInteger()) {
            sum = sum + nestedInt.getInteger() * depth;
        }
        else {
            List<NestedInteger> list = nestedInt.getList();
            
            for (int i = 0; i < list.size(); i++) {
                sum = sum + depthSumHelper(list.get(i), depth + 1);
            }   
        }
        
        return sum;
    }
}