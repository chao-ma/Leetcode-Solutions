class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int divider = 1;
        while (x / divider >= 10) {
            divider *= 10;
        }
        while (x > 0) {
            if (x / divider != x % 10) {
                return false;
            }
            x = x - x / divider * divider;
            x = x / 10;
            divider /= 100;
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(Integer.MAX_VALUE));
    }

}
