import java.util.*;

class WordDictionary {

    public static class TrieNode {
        public boolean mark = false;
        public TrieNode[] children = new TrieNode[26];
    }
    
    public TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int index;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.mark = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        List<TrieNode> queue = new LinkedList<>();
        List<TrieNode> nextQueue = new LinkedList<>();
        List<TrieNode> swap;
        int index;
        queue.add(root);
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) == '.' ? -1 : word.charAt(i) - 'a';
            while (!queue.isEmpty()) {
                TrieNode node = queue.remove(0);
                if (index < 0) {
                    for (TrieNode child: node.children) {
                        if (child != null)
                            nextQueue.add(child);
                    }
                } else {
                    if (node.children[index] != null)
                        nextQueue.add(node.children[index]);
                }
            }
            swap = queue;
            queue = nextQueue;
            nextQueue = swap;
        }
        for (TrieNode node: queue)
            if (node.mark)
                return true;
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordDictionary dict = new WordDictionary();
        String[] words = {"cat", "catt", "bat","bad","bed","children", ""};
        for (String word: words)
            dict.addWord(word);
        System.out.println(dict.search("..t"));
    }

}
