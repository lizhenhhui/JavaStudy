package Code.SIngleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Main {
    //暴力反射
    public static void main (String[] args) throws Exception {
        Class<?> aClass = Class.forName(Singleton4.class.getName());
        System.out.println(Singleton4.class.getName());


        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Method a = aClass.getDeclaredMethod("a",String.class);
        a.setAccessible(true);
        String test =(String) a.invoke(Singleton4.getINSTANCE(), "avasfd");
        System.out.println(test);

        Singleton4 singleton4= (Singleton4) declaredConstructor.newInstance();


        System.out.println(Singleton4.getINSTANCE());
        System.out.println(singleton4);

    }

}
