import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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
    
    static class IntervalComparator implements Comparator <Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start)
                return -1;
            else if (o1.start > o2.start)
                return 1;
            return 0;
        }       
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> retValue = new ArrayList<>();
        for (Interval interval: intervals) {
            while (retValue.size() > 0 && interval.start <= retValue.get(retValue.size() - 1).end) {
                Interval top = retValue.remove(retValue.size() - 1);
                interval = new Interval(top.start, Math.max(interval.end, top.end));
            }
            retValue.add(interval);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] nums = {{1,3},{2,6},{1,2},{8,10},{15,18}};
        List<Interval> intervals = new ArrayList<>();
        for (int[] interval: nums) {
            Interval i = new Interval(interval[0], interval[1]);
            intervals.add(i);
        }
        Solution solution = new Solution();
        List<Interval> res = solution.merge(intervals);
        System.out.println(res);
    }

}
