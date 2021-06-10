/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((i1, i2) -> i1.start - i2.start);
        
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }
        
        List<Interval> ans = new ArrayList<>();
        
        Interval curr = pq.poll();
        while (!pq.isEmpty()) {
            // no intersection, then this is free time split.
            if (curr.end < pq.peek().start) {
                Interval free = new Interval(curr.end, pq.peek().start);
                ans.add(free);
                
                curr = pq.poll();
            }
            else {
                Interval next = pq.poll();
                if (curr.end < next.end) {
                    curr = next;
                }
            }
        }
        
        return ans;
    }
}
