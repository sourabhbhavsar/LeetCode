class StockPrice {

    Map<Integer, Integer> priceMap;
    TreeMap<Integer, Integer> priceCountMap;
    int latestTimeStamp;
    
    public StockPrice() {
        priceMap = new HashMap<>();
        priceCountMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        latestTimeStamp = Math.max(latestTimeStamp, timestamp);
        
        if (priceMap.containsKey(timestamp)) {
            int oldPrice = priceMap.get(timestamp);
            int oldPriceCount = priceCountMap.get(oldPrice);
            if (oldPriceCount == 1) {
                priceCountMap.remove(oldPrice);
            }
            else {
                priceCountMap.put(oldPrice, oldPriceCount - 1);
            }
        }
        
        priceMap.put(timestamp, price);
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return priceMap.get(latestTimeStamp);
    }
    
    public int maximum() {
        return priceCountMap.lastKey();
    }
    
    public int minimum() {
         return priceCountMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
