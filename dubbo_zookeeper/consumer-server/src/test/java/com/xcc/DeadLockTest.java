package com.xcc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuhe
 * @PackageName:com.xcc
 * @ClassName:DeadLockTest
 * @Description:
 * @data 2022/6/11 21:52
 */

public class DeadLockTest implements Runnable {
    //进入锁的控制符 n多少个线陈争夺，这个flag最大就为n-1
    private int flag;

    public DeadLockTest(int flag) {
        this.flag = flag;
    }

    //静态锁对象，被DeadLockTest的所有实例对象所公用 同样这里也是n-1个所对象
    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public void run() {

        System.out.println("当前的锁标志：" + flag);
        if (flag == 0) {
            synchronized (lock1) {
                try {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock1);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待获得锁" + lock2);
                synchronized (lock2) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock2);
                }
            }
        }
        if (flag == 1) {

            synchronized (lock2) {
                try {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock2);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待获得锁" + lock1);
                synchronized (lock1) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock1);
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest test1 = new DeadLockTest(0);
        DeadLockTest test2 = new DeadLockTest(1);
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
        ConcurrentHashMap chm = new ConcurrentHashMap();
    }
}