class Solution {
    public double myPow(double x, int n) {
        double retValue = 1.0;
        boolean signed = false;
        double aggregator = x;
        if (n < 0) {
            signed = true;
            n = -n;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                retValue *= aggregator;
            }
            n /= 2;
            aggregator *= aggregator;
        }
        if (signed) {
            retValue = 1.0f / retValue;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.myPow(-2, -5));
    }

}
