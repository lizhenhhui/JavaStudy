package Code.SIngleton;

/**
 * @description:
 * @author:12604
 * @time:2024/5/29 下午8:38
 */
public enum Singleton2 {
    INSTANCE;
    private Singleton2(){}

    private Singleton2 getInstance(){
        return INSTANCE;
    }

}
