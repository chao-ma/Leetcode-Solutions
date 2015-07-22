import java.util.*;

class MinStack {
    
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
