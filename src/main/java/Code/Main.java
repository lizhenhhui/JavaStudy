package Code;


class Main{
    //暴力反射
    public static void main (String[] args) throws Exception {

        System.out.println(gcd(100,20));
    }
    public static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }

}