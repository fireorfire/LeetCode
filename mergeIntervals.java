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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<>();
        for(int i = 0; i < intervals.size(); i++) {
            Interval first = intervals.get(i);
            int j;
            for(j = i + 1; j < intervals.size(); j++) {
                Interval second = intervals.get(j);
                if(second.start <= first.end) {
                    first.start = Math.min(first.start, second.start);
                    first.end = Math.max(first.end, second.end);
                }else
                    break;
            }
            i = j - 1;
            result.add(first);
        }
        return result;
    }
}