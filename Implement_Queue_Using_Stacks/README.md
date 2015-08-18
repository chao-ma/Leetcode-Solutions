Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

```java
class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> auxStack = new Stack<>();
    private int head = 0;
    // Push element x to the back of queue.
    public void push(int x) {
        if (stack.isEmpty())
            head = x;
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!stack.isEmpty())
            auxStack.push(stack.pop());
        auxStack.pop();
        if (!auxStack.isEmpty())
            head = auxStack.peek();
        while (!auxStack.isEmpty())
            stack.push(auxStack.pop());
    }

    // Get the front element.
    public int peek() {
        return head;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
```
