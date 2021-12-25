class RandomizedSet {

    private Random random;
    private List<Integer> list;
    private Map<Integer, Integer> indexMap;
    
    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        
        list.add(val);
        indexMap.put(val, list.size() - 1);
        
        return true;
    }

    /*
    *ArrayList's remove method is O(n) if you remove from random location. To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from the end of the list. After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.
    */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        
        int position = indexMap.get(val);
        int lastIndex = list.size() - 1;
        Collections.swap(list, position, lastIndex);
         // update the value at position
        indexMap.put(list.get(position), position);
        
        list.remove(lastIndex);
        indexMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = list.size();
        int index = random.nextInt(size);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
