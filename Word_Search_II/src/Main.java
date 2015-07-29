import java.util.*;

class Solution {

    public static class TrieNode {
        public boolean mark = false;
        public TrieNode[] children = new TrieNode[26];
    }
    
    public TrieNode root = new TrieNode();
    Set<String> retValue = new HashSet<>();
    
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
    
    private void search(char[][] board, int row, int col, TrieNode node, char[] path, int depth) {
        if (depth == path.length)
            return;
        int index = board[row][col] - 'a';
        if (node.children[index] == null)
            return;
        path[depth] = board[row][col];
        board[row][col] = '.';
        TrieNode child = node.children[index];
        if (child.mark)
            retValue.add(String.copyValueOf(path, 0, depth + 1));
        if (row - 1 >= 0 && board[row - 1][col] != '.')
            search(board, row - 1, col, child, path, depth + 1);
        if (row + 1 < board.length && board[row + 1][col] != '.')
            search(board, row + 1, col, child, path, depth + 1);
        if (col - 1 >= 0 && board[row][col - 1] != '.')
            search(board, row, col - 1, child, path, depth + 1);
        if (col + 1 < board[row].length && board[row][col + 1] != '.')
            search(board, row, col + 1, child, path, depth + 1);
        board[row][col] = path[depth];
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int nRow = board.length;
        if (nRow == 0)
            return new LinkedList<String>(retValue);
        int nCol = board[0].length;
        if (nCol == 0)
            return new LinkedList<String>(retValue);
        int maxLen = 0;
        for (String word: words) {
            addWord(word);
            maxLen = Math.max(maxLen, word.length());
        }
        char[] path = new char[maxLen];
        for (int i = 0; i < nRow; i++)
            for (int j = 0; j < nCol; j++)
                search(board, i, j, root, path, 0);
        return new LinkedList<String>(retValue);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain", "a", "thie"};
        Solution solution = new Solution();
        System.out.println(solution.findWords(board, words));
    }

}
