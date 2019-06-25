package io.haicheng;

import java.util.Stack;

/**
 * <p>Title: Stak</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/21 10:48
 */
public class Stak {

    public boolean isValid(String s) {

        if (null == s || "" == s) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.size() == 0) {
                stack.push(c);
            } else if (isLeague(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;

    }

    private boolean isLeague(char c1, char c2) {
        return ('[' == c1 && ']' == c2) || ('{' == c1 && '}' == c2) || ('(' == c1 && ')' == c2);
    }

    public static void main(String[] args) {
        Stak s = new Stak();
        boolean ret = s.isValid("{}[]");
        System.out.println(ret);
    }
}
