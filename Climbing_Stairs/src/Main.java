class Solution {
    public int climbStairs(int n) {
        if (n < 3) { //not taking care of negative n
            return n;
        }
        int a = 1, b = 2, tmp;
        for (int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }

}
