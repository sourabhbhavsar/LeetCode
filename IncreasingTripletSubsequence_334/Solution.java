]class Solution {
    /**
    Intuitively what this solution does is keeps tracks of lower the bounds for the first and second element of the subsequence. Instead of small and big I will call it first and second initially we have first = INF and second = INF. Also I will simplify your test case to [1,0,2,0,-1,3]

Iteration One
first = 1 second = INF
Iteration Two
first = 0 second = INF
Iteration Three
first = 0 second = 2
Iteration Four (Nothing Changes)
first = 0 second = 2
Iteration Five (Confusing Part)
first = -1 second = 2
Iteration Six
return true; Since 3 > 2 && 3 > -1
Setting first = -1 is important, yet doesn't change the answer in this case since second = 2 implies that their existed a value that was previously smaller than 2. Now if you find any value greater that 2 we know their exist in an increasing triplet sub sequence. But notice if we had a test case like this [1,0,2,0,-1,0,1] we now could see the importance of the updated lower bound for first = -1, so we we can have a correct lower bound for second = 0. And also note this answer ask for existence, and not to construct the triplet, as this solution wouldn't be able to in its current form
    **/
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            }
            else if (nums[i] <= second) {
                second = nums[i];;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
