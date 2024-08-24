package Code.BlockArray;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description:
 * @author:12604
 * @time:2024/8/24 下午3:25
 */
public class BlockQueue<T> {
    private Queue<T>queue;
    private int capacity;
    public BlockQueue(int capacity){
        this.capacity=capacity;
        queue=new ArrayDeque<>();
    }

    public synchronized  void put(T value) throws Exception {
        while (queue.size()==this.capacity){
            wait();
        }

        queue.offer(value);
        notifyAll();
    }

    public synchronized T take() throws Exception{
        while (queue.isEmpty()){
            wait();
        }
        T value=queue.poll();
        notifyAll();
        return value;
    }

    public static void main(String[] args) {
        BlockQueue<Integer>queue=new BlockQueue<>(3);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        queue.put(i);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();

        System.out.println();

    }
}
