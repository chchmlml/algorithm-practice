package io.haicheng;

/**
 * <p>Title: Fibnacci</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/7/15 10:29
 */
public class Fibonacci {


    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        f.fib(5);
    }

    public int fib(int i) {

        if (1 == i || 2 == i) {

            return i;
        }

        return fib(i - 2) + fib(i - 1);
    }
}
