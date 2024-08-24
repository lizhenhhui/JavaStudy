package Code;

public class MonopolyGame {
    public static void main(String[] args) {
        int n = 10; // 示例值
        int[] a = {0,-1 ,2 ,3 ,4 ,-9 ,-9 ,-1 ,3 ,-1 ,-1}; // 示例金币奖励数组，其中包含负数

        // 动态规划数组
        final int INF = Integer.MIN_VALUE;
        int[][] dp = new int[n + 1][16]; // 16 = 2^4，表示4张卡牌的所有状态

        // 初始化 dp 数组
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 16; j++) {
                dp[i][j] = INF; // 设置为负无穷大，表示尚未到达的状态
            }
        }
        dp[0][0] = a[0]; // 从城市 0 开始，金币数为 a[0]，初始卡牌状态为 0000（未使用任何卡牌）

        // 填充 dp 数组
        for (int i = 0; i <= n; i++) {
            for (int mask = 0; mask < 16; mask++) {
                if (dp[i][mask] != INF) {
                    // 对每个可能的卡牌
                    for (int k = 0; k < 4; k++) {
                        if ((mask & (1 << k)) == 0) { // 如果卡牌 k 未使用
                            int nextCity = i + (k + 1);
                            if (nextCity <= n) {
                                int newMask = mask | (1 << k);
                                int newGold = dp[i][mask] + a[nextCity];
                                if (newGold >= 0) { // 确保剩余金币非负
                                    dp[nextCity][newMask] = Math.max(dp[nextCity][newMask], newGold);
                                }
                            }
                        }
                    }
                }
            }
        }
        int maxGold = INF;
        for (int mask = 0; mask < 16; mask++) {
            maxGold = Math.max(maxGold, dp[n][mask]);
        }

        if (maxGold == INF) {
            System.out.println("无法到达城市 " + n + "，金币数为负");
        } else {
            System.out.println("最大金币数: " + maxGold);
        }
    }
}



