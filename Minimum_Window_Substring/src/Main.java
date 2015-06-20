import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        String retValue = "";
        int substrBegin = 0, substrEnd = 0;
        HashMap<Character, Integer> ptnCount = new HashMap<>();
        int i;
        int ptnLength = t.length();
        Character key;
        for (i = 0; i < t.length(); i++) {
            if (ptnCount.containsKey(t.charAt(i))) {
                ptnCount.put(t.charAt(i), ptnCount.get(t.charAt(i))+ 1);
            } else {
                ptnCount.put(t.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> queueStat = new HashMap<>();
        ArrayList<Integer> queue = new ArrayList<>();
        for (i = 0; i < s.length(); i++) {
            key = (Character)s.charAt(i);
            if (!ptnCount.containsKey(key))
                continue;
            if (queueStat.containsKey(key)) {
                queueStat.put(key, queueStat.get(key) + 1);
            } else {
                queueStat.put(key, 1);
            }
            queue.add(i);
            if (queueStat.get(key) <= ptnCount.get(key)) {
                ptnLength--;
                if (ptnLength == 0)
                    break;
            }
        }
        if (ptnLength == t.length() || ptnLength > 0) {
            return "";
        } else {
            while (true) {
                key = (Character)s.charAt(queue.get(0));
                if (queueStat.get(key) > ptnCount.get(key)) {
                    queueStat.put(key, queueStat.get(key) - 1);
                    queue.remove(0);
                } else {
                    break;
                }
            }
            substrBegin = queue.get(0);
            substrEnd = queue.get(queue.size() - 1);
            for (i = i + 1; i < s.length(); i++) {
                key = (Character) s.charAt(i);
                if (!ptnCount.containsKey(key))
                    continue;
                queue.add(i);
                queueStat.put(key, queueStat.get(key) + 1);
                while (true) {
                    key = (Character)s.charAt(queue.get(0));
                    if (queueStat.get(key) > ptnCount.get(key)) {
                        queueStat.put(key, queueStat.get(key) - 1);
                        queue.remove(0);
                    } else {
                        break;
                    }
                }
                if (queue.get(queue.size() - 1) - queue.get(0) < substrEnd - substrBegin) {
                    substrEnd = queue.get(queue.size() - 1);
                    substrBegin = queue.get(0);
                }
            }
            return s.substring(substrBegin, substrEnd + 1);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String s = "AAAAAAABBDCCABA", t = "ABAC";
        System.out.println(solution.minWindow(s, t));
    }

}
