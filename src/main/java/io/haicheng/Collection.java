package io.haicheng;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * <p>Title: Collection</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/18 15:39
 */
public class Collection {

    public class ObjectTool<T> {

        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public <T> T show(T t) {
        return t;
    }

    public static void testLinkList() {
        LinkedList l = new LinkedList();
        l.add("hello");
        l.add("world");
        l.add("java");

        Iterator it = l.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println("======= testLinkList ========>");
    }

    public static void testVector() {
        Vector p = new Vector();
        p.addElement("hello");
        p.addElement("world");
        Iterator it = p.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println("======= testVector ========>");
    }

    public static void main(String[] args) {
        Collection.testVector();
        Collection.testLinkList();
    }
}
