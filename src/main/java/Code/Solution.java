package Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        Set<String> set = new HashSet<>();
        for (String str : wordDict)
            set.add(str);
        for (String str : wordDict) {
            for (int i = str.length(); i <=n; i++) {
                dp[i] = dp[i] || (dp[i - str.length()] && set.contains(s.substring(i - str.length(), i)));

            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        wordBreak("applepenapple", Arrays.asList("apple", "pen"));
    }
}