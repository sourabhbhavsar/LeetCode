class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] table  = new int[days.length + 1][397];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = -1;
            }
        }
        
        return minCostDP(days, costs, 0, 0, table);
    }
    
    public int minCostDP(int[] days, int[] costs, int start, int validTill, int[][] table) {
        
        int numDays = days.length;
        
        // System.out.println("start = " + start + ", validTill = " + validTill);
        
        if (numDays == 0) {
            return 0;
        }
        
        if (start >= numDays) {
            return 0;
        }
        
        if (table[start][validTill] != -1) {
            return table[start][validTill];
        }
        
        if (days[start] < validTill) {
            return minCostDP(days, costs, start + 1, validTill, table);
        }
        
        int dayPassToday = costs[0] + minCostDP(days, costs, start + 1, days[start] + 1, table);
        int sevenDayPassToday = costs[1] + minCostDP(days, costs, start + 1, days[start] + 7, table);
        int thirtyDayPassToday = costs[2] + minCostDP(days, costs, start + 1, days[start] + 30, table);
        
        int minOne = Math.min(dayPassToday, sevenDayPassToday);
        int minCost = Math.min(minOne, thirtyDayPassToday);
        
        table[start][validTill] = minCost;
        return minCost;
    }
}
