package com.example.thread;

import org.junit.jupiter.api.Test;

public class ThreadTests {


    static synchronized void run1(){
        System.out.println("类锁方法");
    }
     synchronized  void run2(){
        System.out.println("普通方法");
    }

    @Test
    void run3(){
        ThreadTests threadTests = new ThreadTests();

     new Thread(new Runnable() {
         @Override
         public void run() {
             threadTests.run1();
         }
     }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadTests.run2();
            }
        }).start();



    }
}
