import java.util.*;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "";
        if (numerator == 0)
            return "0";
        boolean signed = numerator > 0 ^ denominator > 0;
        long a = numerator;
        a = a > 0 ? a : -a;
        long b = denominator;
        b = b > 0 ? b : -b;
        String retValue = String.valueOf(a / b);
        a = a % b;
        if (a > 0) {
            retValue += ".";
            List<Character> buffer = new ArrayList<>();
            Map<Long, Integer> valueToPos = new HashMap<>();
            valueToPos.put(0L, -1);
            while (!valueToPos.containsKey(a)) {
                valueToPos.put(a, buffer.size());
                a *= 10;
                buffer.add((char)(a / b + '0'));
                a = a % b;
            }
            char[] x = new char[buffer.size()];
            for (int i = 0; i < x.length; i++) {
                x[i] = buffer.get(i);
            }
            if (a == 0) {
                retValue += String.copyValueOf(x);
            } else {
                int repeatPos = valueToPos.get(a);
                retValue += String.copyValueOf(x, 0, repeatPos) + "(" + 
                            String.copyValueOf(x, repeatPos, x.length - repeatPos)+ ")";
            }
        }
        if (signed)
            retValue = "-" + retValue;
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // test cases 0/0, 0/5, 1/5, 10/2, -10/2, 1/7, 8/7, 1 / 13, 1/36, 2/36
        Solution solution = new Solution();
        int numerator = 1, denominator = 36;
        System.out.println(solution.fractionToDecimal(numerator, denominator));
    }

}
