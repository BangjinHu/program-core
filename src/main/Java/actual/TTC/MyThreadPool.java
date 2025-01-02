package actual.TTC;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {

    //    编程题：java语言实现一个线程池
    //        1）根据配置启动n个线程，线程启动后原则上程序不结束不退出，可以循环空转
    //        2）当新的任务进来时使用一个线程，任务执行完成时释放一个线程（置为空闲，不结束）
    //        3）当线程池已被任务填满时，让新任务等待1分钟（或者提示线程已满）
    //        4）关注一下线程执行任务出现exception的处理，尽可能保证线程不退出

    int poolSize;
    List<Thread> threadList = new ArrayList<>();

    public MyThreadPool(int poolSize) {
        this.poolSize = poolSize;
    }

    public void execute(Runnable task) {
        synchronized (threadList) {
            if (threadList.size() < poolSize) {
                MyThread worker = new MyThread(task);
                worker.start();
            } else {
                throw new RuntimeException("thread pool already full.");
            }
        }
    }

    class MyThread extends Thread {

        private final Runnable task;

        public MyThread(Runnable task) {
            super(task);
            this.task = task;
        }

        @Override
        public void run() {
            super.run();
            while (task != null) {
                try {
                    System.out.println("invoking task.");
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("invoking exception, but continue invoke.");
                }
            }
        }
    }
}
