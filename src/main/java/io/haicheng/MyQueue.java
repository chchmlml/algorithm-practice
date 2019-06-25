package io.haicheng;

import java.util.Stack;

/**
 * <p>Title: MyQueue</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/21 11:18
 */
public class MyQueue {

    private Stack<Integer> input = null;
    private Stack<Integer> output = null;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (output.empty() && input.empty()) {
            return -1;
        }
        change();
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (output.empty() && input.empty()) {
            return -1;
        }
        change();
        return output.peek();
    }

    private void change() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return output.empty() && input.empty();
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        int x = m.peek();
        System.out.println(x);
        int x2 = m.pop();
        System.out.println(x2);
        boolean empty = m.empty();
        System.out.println(empty);

    }
}
