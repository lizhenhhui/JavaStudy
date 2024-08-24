package Code;

/**
 * @description:
 * @author:12604
 * @time:2024/8/3 下午3:11
 */
public class Gcd {
    public static int gcd(int a, int b) {// 辗转相除法 改进,调用函数递归
        return (a % b == 0) ? b : gcd(b, a%b );// 相同思路,三元运算/简化写法
    }

    public static void main(String[] args) {
        System.out.println(gcd(15,10));
    }
}
