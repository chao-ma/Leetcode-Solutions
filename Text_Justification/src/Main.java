import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> retValue = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        int length = 0;
        int i, j, k, spaces, cutoff;
        char[] buff = new char[maxWidth];
        for (String word: words) {
            if (lineWords.size() == 0) {
                lineWords.add(word);
                length += word.length();
            } else {
                if (length + lineWords.size() + word.length() > maxWidth) {
                    for (i = 0; i < lineWords.get(0).length(); i++) {
                        buff[i] = lineWords.get(0).charAt(i);
                    }
                    if (lineWords.size() == 1) {
                        for (i = length;i < buff.length; i++) {
                            buff[i] = ' ';
                        }
                    } else {
                        spaces = (maxWidth - length) / (lineWords.size() - 1);
                        cutoff = (maxWidth - length) % (lineWords.size() - 1);
                        j = i;
                        for (i = 1; i < lineWords.size(); i++ ) {
                            for (k = 0; k < spaces; k++) {
                                buff[j++] = ' ';
                            }
                            if (i <= cutoff) {
                                buff[j++] = ' ';
                            }
                            for (k = 0; k < lineWords.get(i).length(); k++) {
                                buff[j++] = lineWords.get(i).charAt(k);
                            }
                        }
                    }
                    lineWords.clear();
                    lineWords.add(word);
                    length = word.length();
                    retValue.add(String.copyValueOf(buff));
                } else {
                    lineWords.add(word);
                    length += word.length();
                }
            }
        }
        if (lineWords.size() > 0) {
            j = 0;
            for (k = 0; k < lineWords.get(0).length(); k++) {
                buff[j++] = lineWords.get(0).charAt(k);
            }
            for (i = 1; i < lineWords.size(); i++) {
                buff[j++] = ' ';
                for (k = 0; k < lineWords.get(i).length(); k++) {
                    buff[j++] = lineWords.get(i).charAt(k);
                }
            }
            for (;j < buff.length; j++) {
                buff[j] = ' ';
            }
            retValue.add(String.copyValueOf(buff));
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = {"This", "is", "an", "example", "of", "text", "justification"};
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(words, 16));
    }

}
 