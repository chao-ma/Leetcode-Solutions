class TrieNode {
    public TrieNode[] children;
    public boolean mark = false;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode head = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (head.children[index] == null)
                head.children[index] = new TrieNode();
            head = head.children[index];
        }
        head.mark = true;
    }

    private TrieNode path(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            if (head.children[word.charAt(i) - 'a'] == null)
                return null;
            head = head.children[word.charAt(i) - 'a'];
        }
        return head;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = path(word);
        return node != null && node.mark;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return path(prefix) != null;        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Trie trie = new Trie();
        trie.insert("children");
        System.out.println(trie.startsWith("children"));
        trie.insert("child");
        System.out.println(trie.search("child"));
        System.out.println(trie.startsWith("children"));
    }

}
