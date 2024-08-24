package Code.Undermining_parental;

import java.util.Arrays;

public class ArrayOperations {

    // 计算指定区间 [l, r] 的和
    public static int getSubarraySum(int[] array, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 计算最大子区间和
    public static int findMaxSubarraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : array) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 计算最小子区间和
    public static int findMinSubarraySum(int[] array) {
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int num : array) {
            currentSum = Math.min(num, currentSum + num);
            minSum = Math.min(minSum, currentSum);
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] array = {-1, -2, -3, 1,2,3};
        int k = 2; // Example multiplier

        int totalSum = Arrays.stream(array).sum();

        // 小美的操作
        int maxSubarraySum = findMaxSubarraySum(array);
        int maxIncrease = (k - 1) * maxSubarraySum;
        int sumAfterMe = totalSum + maxIncrease;

        // 小团的操作
        int newArraySum = Arrays.stream(array).map(x -> x * k).sum();
        int minSubarraySum = findMinSubarraySum(array);
        int minDecrease = (k - 1) * minSubarraySum;
        int finalSum = newArraySum - minDecrease;

        System.out.println("小美的操作后数组和: " + sumAfterMe);
        System.out.println("小团的操作后数组和: " + finalSum);
    }
}
