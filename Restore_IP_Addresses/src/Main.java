import java.util.*;

class Solution {

    List<String> retValue = new ArrayList<>();
    
    private boolean isValidIpSegment(String s) {
        // 100 true, 256 false, 010 false, 0 true
        if (s.length() > 3 || s.length() == 0)
            return false;
        if (s.charAt(0) == '0')
            return s.length() == 1;
        int val = Integer.parseInt(s);
        if (val >= 0 && val < 256)
            return true;
        return false;
    }
    
    private void helper(String s, int level, int[] pos) {
        if (level == 4) {
            if (isValidIpSegment(s.substring(pos[3], pos[4]))) {
                String solution = s.substring(pos[0], pos[1]);
                for (int i = 1; i < 4; i++) {
                    solution = solution + "." + s.substring(pos[i], pos[i + 1]);
                }
                retValue.add(solution);
            }
            return;
        }
        for (int i = pos[level - 1] + 1; i < pos[level - 1] + 4 && i < s.length(); i++) {
            if (isValidIpSegment(s.substring(pos[level - 1], i))) {
                pos[level] = i;
                helper(s, level + 1, pos);
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        int[] pos = new int[5];
        pos[0] = 0;
        pos[4] = s.length();
        helper(s, 1, pos);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<String> res = solution.restoreIpAddresses("100100100");
        System.out.println(res);
    }

}
