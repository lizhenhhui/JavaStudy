package Code.Thread;

/**
 * @description:
 * @author:12604
 * @time:2024/7/3 下午5:00
 */
public class Thread2 {
    private static volatile int count=1;
    private static Object lock=new Object();
    public static void main(String[] args) {
        Thread a=new Thread(()->{
           System.out.print("A");
        });
        Thread b=new Thread(()->{

                try {
                    a.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("B");


        });
        Thread c=new Thread(()->{
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("C");
        });


        a.start();
        b.start();
        c.start();

    }
}
