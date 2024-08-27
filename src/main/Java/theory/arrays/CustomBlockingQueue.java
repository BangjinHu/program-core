package theory.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {

    public static void main(String[] args) {

        CustomBlockingQueue queue = new CustomBlockingQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                queue.add(i);
                System.out.println("到：" + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (;;){
                System.out.println("开始工作，消费：" + queue.take());
                try {
                    Thread.sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }

    //阻塞队列的自定义实现
    private List<Integer> container = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private Condition isNull = lock.newCondition();//队列空
    private Condition isFull = lock.newCondition();//队列满
    private volatile int size;
    private volatile int capacity;
    CustomBlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void add(int value){
        try {
            lock.lock();
            try {
                while (size >= capacity){
                    System.out.println("队列满，释放锁，等待消费者消费数据！");
                    isFull.await();
                }
            }catch (InterruptedException e){
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(value);
            isNull.signal();
        }finally {
            lock.unlock();
        }
    }

    public int take(){
        try {
            lock.lock();
            try {
                while (size == 0){
                    System.out.println("队列空，释放锁，等待生产者生产数据！");
                    isNull.await();
                }
            }catch (InterruptedException e){
                isFull.signal();
                e.printStackTrace();
            }
            --size;
            int ans = container.get(0);
            container.remove(0);
            isFull.signal();
            return ans;
        }finally {
            lock.unlock();
        }
    }
}
