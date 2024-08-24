package Code;

import java.util.Scanner;

/**
 * @description:
 * @author:12604
 * @time:2024/8/5 下午8:53
 */
public class Bag {
    //完全背包  所有物品可以重复选
    public static void main1 (String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[][]a=new int[N][2];

        for(int i=0;i<N;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        int []dp=new int[V+1];

        for(int i=0;i<N;i++){
            for(int j=a[i][0];j<=V;j++){
                dp[j]=Math.max(dp[j],dp[j-a[i][0]]+a[i][1]);
            }
        }
        System.out.println(dp[V]);
    }

    //0-1背包
    public static void main2(String[] args){
        Scanner scanner = new Scanner(System.in);
        int M=0;
        int N=0;
        M=scanner.nextInt();
        N=scanner.nextInt();
        int[] weight=new int[M+1];
        int[] value=new int[M+1];
        int tmp=0;
        for(int i=1;i<=M;i++){
            tmp=scanner.nextInt();
            weight[i]=tmp;
        }
        for(int i=1;i<=M;i++){
            tmp=scanner.nextInt();
            value[i]=tmp;
        }

        int[] bag=new int[N+1];
        for(int i=1;i<=M ;i++){
            for(int j=N;j>=weight[i];j--){
                bag[j]=Math.max(bag[j-weight[i]]+value[i],bag[j]);
            }
        }

        System.out.print(bag[N]);

    }

    //多重背包  每个物品有多个 但不是无限
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        int N = in.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            value[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        // dp[j]: 在宇航舱容量为 j 的情况下，能获得的最大价值。
        int[] dp = new int[C + 1];
        dp[0] = 0;
        for (int i = 0; i < N; i++) { // 先遍历物品
            for (int j = C; j >= weight[i]; j--) { // 再遍历背包（01背包，每个物品只能拿一次）
                for (int k = 1; k <= nums[i] && j - k * weight[i] >= 0; k++) { // 个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        System.out.println(dp[C]);
    }

}
