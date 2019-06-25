package io.haicheng;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: MyStack</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/21 11:37
 */
public class MyStack {

    Queue<Integer> q1 = null;
    Queue<Integer> q2 = null;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q1.size() == 0) {
            return -1;
        }
        if (q1.size() == 1) {
            return q1.poll();
        }
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int result = q1.poll();
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (q1.size() == 0) {
            return -1;
        }
        if (q1.size() == 1) {
            int result = q1.poll();
            q1.offer(result);
            return result;
        }
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int result = q1.poll();
        q2.offer(result);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        int t = s.top();
        System.out.println(t);
        int p = s.pop();
        System.out.println(p);
        boolean empty = s.empty();
        System.out.println(empty);
    }
}