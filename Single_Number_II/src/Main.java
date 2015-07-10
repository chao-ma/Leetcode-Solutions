class Solution {
    public int singleNumber(int[] nums) {
        int retValue = 0;
        int mask, i, j, sum;
        for (i = 0; i < 32; i++) {
            sum = 0;
            mask = 1 << i;
            for (j = 0; j < nums.length; j++)
                if ((nums[j] & mask) != 0)
                    sum++;
            if (sum % 3 == 1)
                retValue = retValue | mask;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[] {-2,-2,-2,1,1,1,-3}));
        System.out.println(-1 & ( 1 << 31));
    }

}
