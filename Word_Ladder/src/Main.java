import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (endWord.equals(beginWord))
            return 1;
        Map<String, Integer> wordToStep = new HashMap<>();
        List<String> queue = new LinkedList<>();
        for (String word: wordDict)
            wordToStep.put(word, 0);
        wordToStep.put(beginWord, 1);
        queue.add(beginWord);
        char[] token;
        int i, j;
        while (!queue.isEmpty()) {
            String head = queue.remove(0);
            token = head.toCharArray();
            for (i = 0; i < head.length(); i++) {
                for (j = 0; j < 26; j++) {
                    token[i] = (char)('a' + j);
                    String word = String.copyValueOf(token);
                    if (word.equals(endWord))
                        return wordToStep.get(head) + 1;
                    if (wordToStep.containsKey(word) && wordToStep.get(word) == 0) {
                        wordToStep.put(word, wordToStep.get(head) + 1);
                        queue.add(word);
                    }
                }
                token[i] = head.charAt(i);
            }
        }
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String[] words = {"hot","dot","dog","lot","log"};
        Set<String> wordDict = new HashSet<>();
        for (String word: words)
            wordDict.add(word);
        String beginWord = "hit"; String endWord = "cog";
        System.out.println(solution.ladderLength(beginWord, endWord, wordDict));
    }

}
