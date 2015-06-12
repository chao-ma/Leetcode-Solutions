import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}


class Solution {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> retValue = new ArrayList<>();
        boolean newIntervalAdded = false;
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start) {
                retValue.add(interval);
            } else if (interval.start > newInterval.end) {
                if (!newIntervalAdded) {
                    retValue.add(newInterval);
                    newIntervalAdded = true;
                }
                retValue.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (!newIntervalAdded) {
            retValue.add(newInterval);
        }
        return retValue;
    }
}
 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] nums = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        List<Interval> intervals = new ArrayList<>();
        for (int[] interval: nums) {
            Interval i = new Interval(interval[0], interval[1]);
            intervals.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.insert(intervals, new Interval(20,50)));
    }

}
