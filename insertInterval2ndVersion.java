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
        
        List<Interval> result = new ArrayList<>();
        for(Interval x: intervals) {
            if(newInterval.start > x.end) {
                result.add(x);
            }else if(newInterval.end < x.start) {
                result.add(newInterval);
                newInterval = x;
            }else {
                newInterval = new Interval(Math.min(newInterval.start, x.start), Math.max(newInterval.end, x.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}