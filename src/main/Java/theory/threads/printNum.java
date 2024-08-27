package theory.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class printNum {

    public static void main(String[] args) {

        AtomicInteger idx1 = new AtomicInteger();
        AtomicInteger idx2 = new AtomicInteger();
        Thread thread2 = null;
        Thread thread1 = null;
        Thread finalThread = thread2;
        Thread finalThread1 = thread1;
        thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("t1: " + i);
                    finalThread.notify();
                } finally {
                    try {
                        finalThread1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("t2: " + i);
                    finalThread1.notify();
                } finally {
                    try {
                        finalThread.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }


}
