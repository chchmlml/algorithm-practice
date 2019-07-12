package io.haicheng;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: ClassLoaderTest</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/7/10 09:29
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        int count = 30;
        List<Integer> backend = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            backend.add(i);
        }

        int index = 1;
        while (index++ <= 100) {

            System.out.println(index + " ==> backend " + index % backend.size());

        }

        //        Integer a = 1;
        //        Integer b = 2;
        //        Integer c = 3;
        //        Integer d = 3;
        //        Integer e = 321;
        //        Integer f = 321;
        //        Long g = 3L;
        //        System.out.println(c == d);
        //        System.out.println(e == f);
        //        System.out.println(c == (a + b));
        //        System.out.println(c.equals(a + b));
        //        System.out.println(g == (a + b));
        //        System.out.println(g.equals(a + b));
    }
}
