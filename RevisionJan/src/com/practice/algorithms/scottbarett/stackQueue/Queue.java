package com.practice.algorithms.scottbarett.stackQueue;

public class Queue {
    private Stack<Integer> stack;
    Stack<Integer> temp;

    public Queue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(value);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Integer dequeue() {
        if (!stack.isEmpty())
            return stack.pop();
        return -1;
    }

}
