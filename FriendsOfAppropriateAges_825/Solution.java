class Solution {
    public int numFriendRequests(int[] ages) {
        
        if (ages == null || ages.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> ageMap = new HashMap<>();
        int count = 0;
        
        for (int age : ages) {
            ageMap.put(age, ageMap.getOrDefault(age, 0) + 1);
        }
        
        for (int age1 : ageMap.keySet()) {
            for (int age2 : ageMap.keySet()) {
                if (canSendFriendRequest(age1, age2)) {
                    int countAge1 = ageMap.get(age1);
                    int countAge2 = ageMap.get(age2);
                    
                    if (age1 == age2) {
                        // can not send friend request to self.
                        countAge2 = countAge2 - 1;
                    }
                    
                    count = count + countAge1 * countAge2;
                }
            }
        }

        return count;
    }
 
    public boolean canSendFriendRequest(int age1, int age2) {
        // B > A
        if (age1 < age2) {
            return false;
        }
        
        // B <= 0.5 * A + 7
        if (age2 <= ( (double)(age1 / 2) + 7)) {
            return false;
        }
        
        return true;
    }
}
