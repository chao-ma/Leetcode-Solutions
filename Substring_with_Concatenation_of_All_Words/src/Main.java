import java.util.*;

class Solution {
    
    HashMap<String, Integer> wordCount = new HashMap<>();
    HashMap<String, Integer> observedWordCount = new HashMap<>();
    LinkedList<String> wordQueue = new LinkedList<>();
    
    private void addWord(String word) {
        if (observedWordCount.containsKey(word)) {
            observedWordCount.put(word, observedWordCount.get(word) + 1);
        } else {
            observedWordCount.put(word, 1);
        }
        wordQueue.add(word);
    }
    
    private int getSize() {
        return wordQueue.size();
    }
    
    private void clear() {
        observedWordCount.clear();
        wordQueue.clear();
    }
    
    private int getObservedWordCount(String word) {
        if (observedWordCount.containsKey(word)) {
            return observedWordCount.get(word);
        }
        return 0;
    }
    
    private void removeHeadUntil(String word) {
        String head;
        do {
            head = wordQueue.remove();
            observedWordCount.put(head, observedWordCount.get(head) - 1);
        } while(!head.equals(word));
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> retValue = new ArrayList<>();
        int strLen = s.length();
        if (strLen == 0 || words.length == 0) {
            return retValue;
        }
        int wordLen = words[0].length();
        int i, j;
        String token;
        for (String word: words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        for (j = 0; j< wordLen; j++) {
            clear();
            for (i = j; i + wordLen <= strLen; i += wordLen) {
                token = s.substring(i, i + wordLen);
                if (wordCount.containsKey(token)) {
                    addWord(token);
                    if (getObservedWordCount(token) > wordCount.get(token)) {
                        removeHeadUntil(token);
                    }
                    if (getSize() == words.length) {
                        retValue.add(i + wordLen - wordLen*words.length);
                    }
                } else {
                    clear();
                }
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        //String[] words = {"foo", "bar"}; String s="barfoothefoobarman";
        String[] words = {"aa","aa"}; String s="aaa";
        System.out.println(solution.findSubstring(s, words));
    }

}
