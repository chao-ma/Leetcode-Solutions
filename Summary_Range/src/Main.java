import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<int[]> ranges = new ArrayList<>();
        for (int num: nums) {
            if (ranges.size() == 0)
                ranges.add(new int[] {num, num});
            else {
                if (num == ranges.get(ranges.size() - 1)[1] + 1)
                    ranges.get(ranges.size() - 1)[1] = num;
                else
                    ranges.add(new int[] {num, num});
            }
        }
        List<String> strRanges = new ArrayList<>();
        for (int[] range: ranges) {
            if (range[0] == range[1])
                strRanges.add(String.valueOf(range[0]));
            else
                strRanges.add(String.format("%d->%d", range[0], range[1]));
        }
        return strRanges;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {0,1,2,4,5,7};
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(nums));
    }

}
