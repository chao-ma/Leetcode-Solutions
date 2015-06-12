class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        char[] buff = new char[n];
        int factor = 1;
        int i, j, m, l;
        for (i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (i = 1; i < n; i++) {
            factor *= i;
        }
        k = k - 1;
        for (i = 0; i < n - 1; i++) {
            j = k / factor;
            l = 0; m = 0;
            while (true) {
                if (nums[l] != 0)
                    m++;
                if (m == j + 1)
                    break;
                l++;
            }
            buff[i] = (char)('0' + nums[l]);
            nums[l] = 0;
            k = k % factor;
            factor = factor / (n - 1 - i);
        }
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                buff[i] = (char)('0' + nums[j]);
            }
        }
        return String.copyValueOf(buff);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(2, 2));
        for (int i = 1; i <= 6*4; i++)
            System.out.println(solution.getPermutation(4, i));
    }

}
