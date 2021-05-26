

class Solution {
    
    class Interval {
        public int start;
        public int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public String toString() {
            return "start = " + start + ", end = " + end;
        }
    }
    
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        
        for (int i = 0; i < dict.length; i++) {
            String word = dict[i];
            
            int index = s.indexOf(word, 0);
            
            while (index != -1) {
                Interval interval = new Interval(index, index + word.length());
                intervals.add(interval);
                index = s.indexOf(word, index + 1);
            }
        }
        
        Collections.sort(intervals, 
                         (Interval a, Interval b) -> (a.start - b.start));
        
        List<Interval> merged = mergeIntervals(intervals);
        // System.out.println(intervals);
        // System.out.println(merged);
        
        StringBuilder sb = new StringBuilder("");
        int start = 0;
        for (Interval inter : merged) {
            String part1 = s.substring(start, inter.start);
            sb.append(part1);
            sb.append("<b>");
            String part2 = s.substring(inter.start, inter.end);
            sb.append(part2);
            sb.append("</b>");
            
            start = inter.end;
        }
        
        if (start < s.length()) {
            sb.append(s.substring(start));
        }
        
        return sb.toString();
    }
    
    public List<Interval> mergeIntervals(List<Interval> intervals) {
        
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        List<Interval> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval lastInterval = merged.get(merged.size() - 1);
            
            if (curr.start <= lastInterval.end) {
                lastInterval.end = Math.max(curr.end, lastInterval.end);
            }
            else {
                merged.add(curr);
            }
        }
        
        return merged;
    }
}
