import java.util.*;

class Solution {
    Map<Integer, Integer> numberToCount = new HashMap<>();
    public int countDigitOne(int n) {
        if (n == 0)
            return 0;
        if (n < 10)
            return 1;
        if (numberToCount.containsKey(n))
            return numberToCount.get(n);
        int base = 1;
        while (n / base > 9)
            base *= 10;
        int numOnes = countDigitOne(base - 1);
        if (n / base == 1) {
            numOnes += countDigitOne(n - base) + n - base + 1;
        } else {
            numOnes += base + countDigitOne(base - 1);
            int i;
            for (i = 2; i < 10 && n / base > i; i++)
                numOnes += countDigitOne(base - 1);
            numOnes += countDigitOne(n - i * base);
        }
        numberToCount.put(n, numOnes);
        return numOnes;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int n = 738;
        System.out.println(solution.countDigitOne(n));
    }

}
