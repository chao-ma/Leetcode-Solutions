import java.util.*;

class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<String, List<String>> wordToParents = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<String> queue = new LinkedList<>();
        Set<String> layer = new HashSet<>();
        List<List<String>> retValue = new LinkedList<>();
        char[] buffer;
        int i, j;
        queue.add(start);
        dict.add(end);
        visited.add(start);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String head = queue.remove(0);
                buffer = head.toCharArray();
                for (i = 0; i < buffer.length; i++) {
                    for (j = 0; j < 26; j++) {
                        buffer[i] = (char)('a' + j);
                        String word = String.copyValueOf(buffer);
                        if (dict.contains(word) && !visited.contains(word)) {
                            if (!wordToParents.containsKey(word))
                                wordToParents.put(word, new ArrayList<String>()); 
                            wordToParents.get(word).add(head);
                            layer.add(word);
                        }
                    }
                    buffer[i] = head.charAt(i);
                }
            }
            for (String s: layer) {
                visited.add(s);
                queue.add(s);
            }
            if (layer.contains(end))
                break;
            layer.clear();
        }
        if (wordToParents.containsKey(end)) {
            List<String> solution = new LinkedList<>();
            solution.add(end);
            retValue.add(solution);
            while(wordToParents.containsKey(retValue.get(0).get(0))) {
                solution = retValue.remove(0);
                for (String parent: wordToParents.get(solution.get(0))) {
                    List<String> newSolution = new LinkedList<>(solution);
                    newSolution.add(0, parent);
                    retValue.add(newSolution);
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
        String[] words = {"hot","dot","dog","lot","log"};
        String start = "hit"; String end = "cog";
        Set<String> dict = new HashSet<>();
        for (String word: words)
            dict.add(word);
        System.out.println(solution.findLadders(start, end, dict));
    }

}
