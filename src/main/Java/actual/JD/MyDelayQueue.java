//package actual.JD;
//
//import java.util.PriorityQueue;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
//// 自定义的DelayQueue实现
//public class MyDelayQueue<E> {
//
//    private final PriorityQueue<DelayedElement<E>> queue;
//    private final ReentrantLock lock;
//    private final Condition available;
//
//    public MyDelayQueue() {
//        queue = new PriorityQueue<>();
//        lock = new ReentrantLock();
//        available = lock.newCondition();
//    }
//
//    // 向延迟队列中添加元素
//    public void put(E element, long delay, TimeUnit unit) {
//        DelayedElement<E> delayedElement = new DelayedElement<>(element, delay, unit);
//        lock.lock();
//        try {
//            queue.add(delayedElement);
//            if (queue.peek() == delayedElement) {
//                available.notifyAll();
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    // 从延迟队列中获取元素，如果元素未到期则等待
//    public E take() throws InterruptedException {
//        lock.lock();
//        try {
//            while (true) {
//                DelayedElement<E> peek = queue.peek();
//                if (peek == null) {
//                    available.wait();
//                } else {
//                    long now = System.nanoTime();
//                    if (peek.expire <= now) {
//                        queue.poll();
//                        return peek.getElement();
//                    } else {
//                        available.wait(peek.expire - now, TimeUnit.NANOSECONDS);
//                    }
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    // 尝试从延迟队列中获取元素，如果元素未到期则立即返回null
//    public E poll() {
//        lock.lock();
//        try {
//            DelayedElement<E> peek = queue.peek();
//            if (peek != null && peek.expire <= System.nanoTime()) {
//                queue.poll();
//                return peek.getElement();
//            }
//            return null;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    // 获取延迟队列的大小
//    public int size() {
//        lock.lock();
//        try {
//            return queue.size();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    // 用于表示延迟队列中的元素
//    class DelayedElement<E> implements Comparable<DelayedElement<E>> {
//        private final E element;
//        private final long delay; // 延迟时间，单位为纳秒
//        private final long expire; // 到期时间，单位为纳秒
//
//        public DelayedElement(E element, long delay, TimeUnit unit) {
//            this.element = element;
//            this.delay = unit.toNanos(delay);
//            this.expire = System.nanoTime() + this.delay;
//        }
//
//        public E getElement() {
//            return element;
//        }
//
//        @Override
//        public int compareTo(DelayedElement<E> other) {
//            return Long.compare(this.expire, other.expire);
//        }
//    }
//}
