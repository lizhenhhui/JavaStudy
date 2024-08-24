package Code.Thread;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author:12604
 * @time:2024/7/28 下午4:25
 */
public class Thread04 {

    //算法题：
    //(多线程)模拟银行叫号，给定银行有5个窗口，每个窗口没5秒处理一个请求：
    //银行大厅有25个座位，坐满之后不再
    //放号：假设每秒中有一个用户进来，请你模拟以上的过程

    static Deque<Integer> list=new ArrayDeque<>();
    private static Object lock=new Object();
    public static void main(String[] args) {
        Thread producer=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=1;
                while (list.size()!=25){
                    list.add(i++);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread01=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock){
                        System.out.println(Thread.currentThread()+"处理了："+list.poll());

                    }

                }
            }
        });
        Thread thread02=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock){
                        System.out.println(Thread.currentThread()+"处理了："+list.poll());

                    }
                }
            }
        });
        producer.start();
        thread01.start();
        thread02.start();
        System.out.println();
    }
}
