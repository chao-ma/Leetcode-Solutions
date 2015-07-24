import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    
    private void pushStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        pushStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode head = stack.pop();
        pushStack(head.right);
        return head.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
