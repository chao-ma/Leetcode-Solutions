import java.util.*;

class MyStack {
    private LinkedList<Integer> queue = new LinkedList<>();
    private int topVal;
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        topVal = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            topVal = queue.remove();
            queue.add(topVal);
        }
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return topVal;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
