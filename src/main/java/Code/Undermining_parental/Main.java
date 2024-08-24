package Code.Undermining_parental;



import java.lang.reflect.Method;



class Main{

    static int []memo;
    public static void main1(String[] args) throws Exception {

        String classPath = "D:\\EDocument\\Code\\IdeaProjects\\Leetcode1\\Code\\Undermining_parental\\Log.class";

        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        String packageNamePath = "Log";
        Class<?> Log = myClassLoader.loadClass(packageNamePath);
        System.out.println("类加载器是:" + Log.getClassLoader());
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }

    public static void main(String[] args) throws Exception {
        //由于 Bootstrap ClassLoader 不是在 java 中实现的，它是在 c 或 c++ 中实现的，所以没有对它的引用，这就是它返回 null 的原因
        Main main=new Main();

        //Main.class.getClassLoader().getParent().getParent()
        System.out.println(Main.class.getClassLoader().getParent().getParent());

    }


}