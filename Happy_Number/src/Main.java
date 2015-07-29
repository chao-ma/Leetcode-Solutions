import java.util.*;
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int tmp, digit;
        while (n > 0) {
            if (n == 1)
                return true;
            if (visited.contains(n))
                return false;
            visited.add(n);
            tmp = 0;
            while (n > 0) {
                digit = n % 10;
                tmp += digit * digit;
                n = n / 10;
            }
            n = tmp;
        }
        return false;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }

}
