package Code.Aop;

/**
 * @description:
 * @author:12604
 * @time:2024/8/24 下午3:41
 */
public class JDKAop {
    public static void main(String[] args) {
        ISolver ori=new Solver();
        ISolver csProxy=(ISolver) new JDKProxyFactory(ori).getProxyInstance();
        csProxy.solve();
    }
}
