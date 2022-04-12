package com.liuyuyao.myproject.demo.零钱兑换II;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/1 上午11:22
 * @description：
 */
public class Review {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Review review = new Review();
        int ans = review.change(10, new int[]{1, 2, 5, 10});
        System.out.println(ans);
    }
}
