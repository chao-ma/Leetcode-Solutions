import java.util.*;

class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> retValue = new ArrayList<>();
        for (String s: strs) {
            char[] buff = s.toCharArray();
            Arrays.sort(buff);
            String key = String.copyValueOf(buff);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) {
                retValue.addAll(map.get(key));
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String[] strs = {"aba","aab","baa","aab", "cc","dd","xcx","xxc"};
        List<String> s = solution.anagrams(strs);
        System.out.println(s);
    }

}
