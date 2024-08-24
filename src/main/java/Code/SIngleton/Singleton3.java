package Code.SIngleton;

/**
 * @description:
 * @author:12604
 * @time:2024/5/29 下午8:39
 */
public class Singleton3 {
    private Singleton3(){};

    private static  Singleton3 INSTANCE;

    public static synchronized   Singleton3 getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE=new Singleton3();
        }
        return INSTANCE;
    }

}
