package com.practice.algorithms.scottbarett.stackQueue;

import java.util.*;

/** this is stack implementation using arraylist */
public class Stack<T> {
    private ArrayList<T> stackList = new ArrayList<T>();

    public ArrayList<T> getStackList() {
        return this.stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.print(stackList.get(i) + "->");
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size(){
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stackList.removeLast();
    }


}
