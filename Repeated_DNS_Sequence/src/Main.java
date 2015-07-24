import java.util.*;

class Solution {
    private int charToInt(char c) {
        switch (c) {
            case 'A': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'G': return 3;
        }
        return 0;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> valSet = new HashSet<>();
        Set<Integer> addedSet = new HashSet<>();
        List<String> retValue = new LinkedList<>();
        if (s.length() > 10) {
            int key = 0;
            int mask = 0x003ffff;
            int i;
            for (i = 0; i < 9; i++) {
                key = (key << 2) + charToInt(s.charAt(i));
            }
            for (i = 9; i < s.length(); i++) {
                key = (key << 2) + charToInt(s.charAt(i));
                if (valSet.contains(key) && !addedSet.contains(key)) {
                    retValue.add(s.substring(i - 9, i + 1));
                    addedSet.add(key);
                } else {
                    valSet.add(key);
                }
                key = key & mask;
            }
        }
        return retValue;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(1 << 2 + 1);
        Solution solution = new Solution();
        String s = "CAAAAAAAAAC";
        System.out.println(solution.findRepeatedDnaSequences(s));
    }

}
