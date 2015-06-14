class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        this.top();
        queue2.poll();
    }

    // Get the top element.
    public int top() {
        if(!queue1.isEmpty()) {
            int n = queue1.size();
            for(int i = 0; i < n - 1; i++) {
                queue1.add(queue1.poll());
            }
            while(!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            while(!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
        return queue2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}