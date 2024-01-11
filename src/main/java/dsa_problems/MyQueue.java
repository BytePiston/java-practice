package dsa_problems;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack_push = new Stack<>();
    Stack<Integer> stack_pop = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack_push.push(x);
    }

    public int pop() {
        while (stack_push.size() > 1) {
            stack_pop.push(stack_push.pop());
        }
        int val = stack_push.pop();
        while (!stack_pop.isEmpty()) {
            stack_push.push(stack_pop.pop());
        }
        return val;
    }

    public int peek() {
        return stack_push.peek();
    }

    public boolean empty() {
        return stack_push.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
