package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {

    public static void test2() {

        Thread t = new Thread(() -> {
            log.debug("running");
        }, "t2");

        t.start();
    }

    public static void test1() {
        Thread t = new Thread() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t.setName("t1");
        t.start();
    }

    public static void test3() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("何雨涵");
            }
        };
        runnable.run();
    }

    public static void test4() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("I'm doing my work");
//                System.out.println("I'm interrupted?" + Thread.currentThread().isInterrupted());
                System.out.println("I'm interrupted?"+Thread.interrupted());
            }
        });

        thread.start();
        Thread.sleep(1);
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
        test4();
    }

}
