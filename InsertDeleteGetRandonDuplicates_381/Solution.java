class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> locations;
    Random rand;
    public RandomizedCollection() {
        list = new ArrayList<>();
        locations = new HashMap<>();
        rand = new java.util.Random();
    }
    
    public boolean insert(int val) {
        boolean ret = false;
        if (!locations.containsKey(val)) {
            locations.put(val, new HashSet<>());
            ret = true;
        }
        
        list.add(val);
        locations.get(val).add(list.size() - 1);
        return ret;
    }
    
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        
        int loc = locations.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        locations.get(val).remove(loc);
        
        if (loc < lastIndex) {
            int lastElement = list.get(lastIndex);
            Collections.swap(list, lastIndex, loc);
            locations.get(lastElement).remove(lastIndex);
            locations.get(lastElement).add(loc);
        }
        
        list.remove(lastIndex);
        if (locations.get(val).isEmpty()) {
            locations.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
