import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        int retValue = 0;
        int mask = 0x0000000f;
        int[] bins = new int[mask + 1];
        int[] input = nums;
        int[] sorted = new int[nums.length];
        int[] tmp;
        int i, j, shift;
        for (j = 0; j < 8; j++) {
            shift = j << 2;
            for (i = 0; i < bins.length; i++)
                bins[i] = 0;
            for (i = 0; i < input.length; i++)
                bins[(input[i] >>> shift) & mask]++;
            for (i = 1; i < bins.length; i++)
                bins[i] += bins[i - 1];
            for (i = input.length - 1; i >= 0; i--)
                sorted[(bins[(input[i] >>> shift) & mask]--) - 1] = input[i];
            tmp = input;
            input = sorted;
            sorted = tmp;
        }
        for (i = 1; i < input.length; i++)
            retValue = Math.max(retValue, input[i] - input[i - 1]);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 4097; i++) {
            input.add(i);
            input.add(Integer.MAX_VALUE - i);
        }
        input.add(5);
        input.add(1000000);
        input.add(0);
        Collections.shuffle(input);
        int[] nums = new int[input.size()];
        for (int i = 0; i < input.size();i++)
            nums[i] = input.get(i);
        System.out.println(solution.maximumGap(nums));
    }

}
