class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
           public int compare(int[] p1, int[] p2){
               int height1 = p1[0];
               int height2 = p2[0];
               int k1 = p1[1];
               int k2 = p2[1];
               return height1 != height2 ? height2 - height1 : k1 - k2;
           }
        });
        
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        
        return ans.toArray(new int[people.length][2]);
    }
}
