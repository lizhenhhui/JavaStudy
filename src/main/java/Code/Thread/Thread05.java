package Code.Thread;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:12604
 * @time:2024/7/28 下午6:58
 */
public class Thread05 {
    public static Map<String,Integer>map=new ConcurrentHashMap<>();
    public static void main(String[] args)  {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(4,4,2000,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                   //读取文件
                    //获取单词
                    while (true){
                        Thread.sleep(1000);
                        String key="a";
                        map.put(key,map.getOrDefault(key,0)+1);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threade=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Scanner sc=new Scanner(System.in);
                    String key=sc.next();
                    int count=map.getOrDefault(key,0);
                    System.out.println(count);
                }
            }
        });

        threade.start();

    }
}
