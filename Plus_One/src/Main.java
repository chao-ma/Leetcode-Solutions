import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[] {1};
        }
        int carry = 1;
        int[] retValue = new int[digits.length + 1];
        int i = 0, sum;
        while (digits.length - 1 - i >= 0) {
            sum = carry + digits[digits.length - 1 - i];
            retValue[retValue.length - 1 - i] = sum % 10;
            carry = sum / 10;
            i++;
        }
        retValue[0] = carry;
        if (retValue[0] == 0) {
            retValue = Arrays.copyOfRange(retValue, 1, retValue.length);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] digits = {0};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }

}
