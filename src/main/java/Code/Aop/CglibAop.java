package Code.Aop;

/**
 * @description:
 * @author:12604
 * @time:2024/8/24 下午4:11
 */
public class CglibAop {
    public static void main(String[] args) {
        MyService myservice=new MyService();

        MyService myServiceProxy= (MyService) new CglibFactory(myservice).getProxyInstance();
        myServiceProxy.doSomething();
    }
}
