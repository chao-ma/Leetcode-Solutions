class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        boolean signed = dividend > 0 ^ divisor > 0;
        long retValue = 0;
        long remainder = dividend > 0 ? dividend: -(long)dividend;
        long i = 1, residue = divisor > 0 ? divisor: -(long)divisor;
        if (residue > remainder)
            return 0;
        while ( residue + residue <= remainder) {
            residue += residue;
            i += i;
        }
        while (i > 0) {
            if (remainder >= residue) {
                retValue += i;
                remainder -= residue;
            }
            residue = residue >> 1;
            i = i >> 1;
        }
        if (signed) {
            retValue = -retValue;
        }
        if (retValue > Integer.MAX_VALUE) {
            retValue = Integer.MAX_VALUE;
        }
        return (int)retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
    }

}
