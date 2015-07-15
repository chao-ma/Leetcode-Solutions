import java.util.*;

class Solution {
    private boolean wordBreakable(String s, Set<String> wordDict) {
        int maxLen = 0;
        for (String word: wordDict)
            maxLen = word.length() > maxLen ? word.length() : maxLen;
        boolean[] dp = new boolean[s.length() + 1];
        int i, j;
        dp[0] = true;
        for (i = 0; i < s.length(); i++)
            for (j = i; j >=0 && (i - j + 1) <= maxLen && !dp[i + 1]; j--)
                dp[i + 1] = wordDict.contains(s.substring(j, i + 1)) && dp[j];
        return dp[s.length()];
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (!wordBreakable(s, wordDict))
            return new LinkedList<String>();
        int maxLen = 0;
        int i, j;
        List<List<String>> dp = new ArrayList<>();
        dp.add(new LinkedList<String>());
        dp.get(0).add("");
        for (String word: wordDict)
            maxLen = word.length() > maxLen ? word.length() : maxLen;
        for (i = 0; i < s.length(); i++) {
            dp.add(new LinkedList<String>());
            for (j = i; j >= 0 && i - j + 1 <= maxLen; j--) {
                if (wordDict.contains(s.substring(j, i + 1))) {
                    for (String sol: dp.get(j)) {
                        if (sol.length() == 0)
                            dp.get(i + 1).add(s.substring(j, i + 1));
                        else
                            dp.get(i + 1).add(sol + " " + s.substring(j, i + 1));
                    }
                }
            }
        }
        return dp.get(s.length());
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String[] words = {"cat", "cats", "and", "sand", "dog"};
        //String s = "catsanddog";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> wordDict = new HashSet<>();
        for (String word: words)
            wordDict.add(word);
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }

}
