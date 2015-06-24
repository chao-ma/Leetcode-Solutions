import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> retValue = new ArrayList<>();
        retValue.add(0);
        int carry = 1;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>(retValue.size() * 2);
            for (Integer j: retValue) {
                tmp.add(j);
            }
            for (int k = retValue.size() - 1; k >= 0; k--) {
                tmp.add(retValue.get(k) + carry);
            }
            carry = carry << 1;
            retValue = tmp;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.grayCode(3));

    }

}
