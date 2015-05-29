/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 class IntervalComparator implements Comparator<Interval> {
     public int compare(Interval i1, Interval i2) {
         return i1.start - i2.start;
     }
 }
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, new IntervalComparator());
        int i;
        for(i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(newInterval.end < curr.start) break;
            if(curr.end < newInterval.start) continue;
            int j;
            for(j = i; j < intervals.size(); j++) {
                Interval potential = intervals.get(j);
                if(!(newInterval.start > potential.end || newInterval.end < potential.start)) {
                    newInterval.start = Math.min(newInterval.start, potential.start);
                    newInterval.end = Math.max(newInterval.end, potential.end);
                }else {
                    break;
                }   
            }
            while(--j >= i) {
                intervals.remove(j);
            }
            intervals.add(i, newInterval);
            return intervals;
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}