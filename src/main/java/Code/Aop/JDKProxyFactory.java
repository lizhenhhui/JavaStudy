package Code.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author:12604
 * @time:2024/8/24 下午3:38
 */
public class JDKProxyFactory {
    private Object target;
    public JDKProxyFactory(Object target){
        this.target=target;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("增强1");
                        Object invoke = method.invoke(target, args);
                        System.out.println("增强2");
                        return null;
                    }
                });
    }
}
