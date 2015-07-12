class MyQueue {
    
    private Stack<Integer> inStack = new Stack<>(), outStack = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        moveInOutStack();
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        moveInOutStack();
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    private void moveInOutStack() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}