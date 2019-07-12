package io.haicheng;

/**
 * <p>Title: Demo</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/7/12 10:20
 */
public class Demo {

    public static void main(String[] args) {
        //       Person c = new Child();
        //       c.eat();

//        Person p = new Person() {
//            @Override
//            public void eat() {
//                System.out.println("child2 is eating");
//            }
//        };
//        p.eat();
//
//        Thread t = new Thread() {
//            public void run() {
//                for (int i = 1; i <= 5; i++) {
//                    System.out.print(i + " ");
//                }
//            }
//        };
//        t.start();
//        System.out.println("main is close");
//
//        Demo out = new Demo();
//        Object obj = out.method();
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);

    }
}

class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}

//    Object method(){
//        final int localVariable = 0;
//        class Inner{
//            void println(){
//                System.out.println("localVariable " + localVariable);
//            }
//        }
//        Object in = new Inner();
//        return in;
//    }
//}

abstract class Person {

    public abstract void eat();
}

class Child extends Person {

    final int i = 100;

    public void eat() {
        System.out.println("child is eating");
    }
}
