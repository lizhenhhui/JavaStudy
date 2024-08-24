package Code.BlockArray;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockingQueue<E> {
    private final List<E> queue = new ArrayList<>();
    private final int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(E element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // 等待直到有空间
        }
        queue.add(element);
        notifyAll(); // 通知所有等待的线程
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // 等待直到有元素
        }
        E element = queue.remove(0);
        notifyAll(); // 通知所有等待的线程
        return element;
    }

    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(10);

        // Producer thread
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    blockingQueue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Integer value = blockingQueue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(150); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
