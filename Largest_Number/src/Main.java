import java.util.*;

class Solution {
    static public class DigitComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }       
    }
    public String largestNumber(int[] nums) {
        String retValue = "";
        List<String> input = new ArrayList<>();
        boolean allZero = true;
        for (int i: nums) {
            input.add(String.valueOf(i));
            if (i > 0)
                allZero = false;
        }
        if (allZero)
            return "0";
        Collections.sort(input, new DigitComparator());
        for (String s: input)
            retValue += s;
        return retValue;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {0 ,9 ,91, 31, 1,4,1,3,100,9900,1024, Integer.MAX_VALUE};
        System.out.println(solution.largestNumber(nums));
    }

}
