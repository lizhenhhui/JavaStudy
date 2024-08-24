package Code.Thread;

/**
 * @description:
 * @author:12604
 * @time:2024/7/25 上午10:45
 */

//两个线程交替打印1-100
public class Thread4 {
    private final static Object lock = new Object();
    private static volatile int count = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    synchronized (lock){
                        while (count!=1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print('A');
                        count=2;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    synchronized (lock){
                        while (count!=2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print('B');
                        count=3;
                        lock.notifyAll();
                    }
                }
            }

        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    synchronized (lock){
                        while (count!=3){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println('C');
                        count=1;
                        lock.notifyAll();
                    }
                }

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
