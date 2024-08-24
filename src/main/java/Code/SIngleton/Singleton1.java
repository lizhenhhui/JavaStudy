package Code.SIngleton;

import java.io.Serializable;

/**
 * @description:
 * @author:12604
 * @time:2024/5/29 下午8:34
 */
public class Singleton1 implements Serializable {
    private static final Singleton1 instance=new Singleton1();
    private Singleton1(){
        if(instance!=null){
            throw new RuntimeException("不能重复创建");
        }
    }

    public static Singleton1 getInstance(){
        return instance;
    }

    public Object readResolve(){
        return instance;
    }
}
