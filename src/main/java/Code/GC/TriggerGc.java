package Code.GC;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:12604
 * @time:2024/8/5 上午9:36
 */
public class TriggerGc {
    private static final int _1MB = 1024 * 1024;

    // -Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGC
    //-XX:+PrintGC   [gc] GC(0) Pause Young (Allocation Failure) 5M->4M(41M) 1.766ms  gc类型 GC前该内存区域使用容量，GC后该内存区域使用容量，该内存区域总容量
    //-XX:+PrintGCDetails
    //-XX:+UseParallelGC 使用ParallelGC垃圾回收器
    public static void main(String[] args) {
        List caches = new ArrayList();
        for(int i=0;i<5;i++){
            caches.add(new byte[3*_1MB]);
        }
        caches.clear();
        System.gc();
        System.gc();

        for(int i=0;i<16;i++){
            caches.add(new byte[1*_1MB]);
        }

//        caches.add(new byte[2*_1MB]);

//        caches.remove(4);
//        caches.remove(3);
//        caches.add(new byte[_1MB]);
//        caches.add(new byte[3*_1MB]);

    }
}
