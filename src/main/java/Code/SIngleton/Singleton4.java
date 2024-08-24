package Code.SIngleton;

/**
 * @description:
 * @author:12604
 * @time:2024/5/29 下午8:42
 */
public class Singleton4 {
    private Singleton4(){};

    private static volatile Singleton4 INSTANCE;

    public static Singleton4 getINSTANCE(){
        if(INSTANCE==null){
            synchronized (Singleton4.class){
                if(INSTANCE==null){
                    INSTANCE=new Singleton4();
                }
            }
        }
        return INSTANCE;
    }

    private String a(String b){
        return b;
    }
}
