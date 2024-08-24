package Code.Thread;

/**
 * @description:
 * @author:12604
 * @time:2024/7/3 下午5:00
 */
public class Thread1 {
    private static volatile int count=1;
    private static Object lock=new Object();
    public static void main(String[] args) {

        Thread a=new Thread(()->{
            for(int i=0;i<10;i++){
                synchronized (lock){
                    while (count!=1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print("A");
                    count=2;
                    lock.notifyAll();
                }
            }
        });
        Thread b=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (lock){
                    while (count!=2){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print("B");
                    count=3;
                    lock.notifyAll();
                }
            }
        });
        Thread c=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (lock){
                    while (count!=3){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("C");
                    count=1;
                    lock.notifyAll();
                }
            }
        });
        a.start();
        b.start();
        c.start();

    }
}
