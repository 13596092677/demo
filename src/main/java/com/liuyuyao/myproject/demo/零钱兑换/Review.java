package com.liuyuyao.myproject.demo.零钱兑换;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/1 上午10:55
 * @description：
 */
public class Review {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - coins[j]] + 1 : Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }

}
