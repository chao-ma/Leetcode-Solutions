class Solution {
    public int reverse(int x) {
        // clean up edge case x = 0 and such
        if (x > -10 && x < 10) {
            return x;
        }
        long reversed = 0;
        int retValue = 0;
        // clean up signed value
        boolean signed = false;
        long buffer = x; // remember 65535 vs -65536, not symmetric
        if (buffer < 0) {
            buffer = -buffer;
            signed = true;
        }
        // start reversing
        int divider = 1; // watch out for overflow
        while (buffer / divider >= 10) {
            divider *= 10;
        }
        while (divider > 0) {
            reversed += divider * (buffer % 10);
            buffer = buffer / 10;
            divider = divider / 10;
        }
        // restore the sign
        if (signed) {
            reversed = - reversed;
        }
        // boundary check
        if (reversed <= Integer.MAX_VALUE && reversed >= Integer.MIN_VALUE) {
            retValue = (int)reversed;
        }
        return retValue;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int x = 123;
        System.out.println(solution.reverse(x));
    }

}
