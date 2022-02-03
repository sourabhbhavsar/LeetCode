class LFUCache {

    Map<Integer, Integer> values;
    Map<Integer, Integer> keytoCount;
    Map<Integer, LinkedHashSet<Integer>> countToKeys;
    int minOccurence = -1;
    int capacity;
    
    public LFUCache(int capacity) {
        values = new HashMap<>();
        keytoCount = new HashMap<>();
        countToKeys = new HashMap<>();
        countToKeys.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        
        int oldCount = keytoCount.get(key);
        countToKeys.get(oldCount).remove(key);
        
        if (oldCount == minOccurence && countToKeys.get(oldCount).size() == 0) {
            minOccurence++;
        }
        
        int newCount = oldCount + 1;
        keytoCount.put(key, newCount);
        if (!countToKeys.containsKey(newCount)) {
            countToKeys.put(newCount, new LinkedHashSet<>());
        }
        
        countToKeys.get(newCount).add(key);
        
        return values.get(key);
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0) {
            return;
        }
            
        if (values.containsKey(key)) {
            values.put(key, value);
            
            get(key);
            return;
        }
        
        if (values.size() >= capacity) {
            // get the key that was added first with the min usr counter value
            int evict = countToKeys.get(minOccurence).iterator().next();
            countToKeys.get(minOccurence).remove(evict);
            keytoCount.remove(evict);
            values.remove(evict);
        }
        
        values.put(key, value);
        keytoCount.put(key, 1);
        countToKeys.get(1).add(key);
        minOccurence = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
