package ComRealQuestion.OPPO;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintThread {
    public static void main(String[] args){
        AtomicInteger i = new AtomicInteger(0);
        Runnable r = new PThread(i);
        try{
            Thread a = new Thread(r, "A");
            Thread b = new Thread(r, "B");
            Thread c = new Thread(r, "C");
            a.start();
            b.start();
            c.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class PThread implements Runnable {

    private AtomicInteger atomicInteger;

    public PThread(AtomicInteger i){
        this.atomicInteger = i;
    }

    @Override
    public void run(){

        for (int i = 0; i < 10; i++){
            try {
                synchronized (atomicInteger){
                    if (atomicInteger.get() % 3 == 0){
                        System.out.println("A");
                        atomicInteger.set(atomicInteger.get() + 1);
                        atomicInteger.notifyAll();
                    }else if (atomicInteger.get() % 3 == 1){
                        System.out.println("B");
                        atomicInteger.set(atomicInteger.get() + 1);
                        atomicInteger.notifyAll();
                    }else if (atomicInteger.get() % 3 == 2) {
                        System.out.println("C");
                        atomicInteger.set(atomicInteger.get() + 1);
                        atomicInteger.notifyAll();
                    }else {
                        atomicInteger.wait();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
