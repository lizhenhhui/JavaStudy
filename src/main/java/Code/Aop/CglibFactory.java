package Code.Aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:12604
 * @time:2024/8/24 下午3:43
 */

public class CglibFactory implements MethodInterceptor {
    private Object target;
    public CglibFactory(Object target){
        this.target=target;

    }
    public Object getProxyInstance(){
        Enhancer en=new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib增强1");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib增强2");
        return null;
    }
}
