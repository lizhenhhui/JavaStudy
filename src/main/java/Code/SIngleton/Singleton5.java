package Code.SIngleton;

/**
 * @description:
 * @author:12604
 * @time:2024/5/29 下午8:45
 */
public class Singleton5 {
    private Singleton5(){};

    private static class Holder{
        static Singleton5 INSTANCE=new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Holder.INSTANCE;
    }
}
