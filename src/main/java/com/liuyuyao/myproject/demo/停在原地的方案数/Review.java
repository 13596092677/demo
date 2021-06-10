package com.liuyuyao.myproject.demo.停在原地的方案数;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/6/6 10:08 上午
 * @description：
 */
public class Review {
    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxPos + 1];
        int mod = (int) (Math.pow(10, 9) + 7);
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= Math.min(i, maxPos); j++) {
                int preLeft = j == 0 ? 0 : dp[i - 1][j - 1];
                int preSame = dp[i - 1][j];
                int preRight = j == maxPos ? 0 : dp[i - 1][j + 1];
                dp[i][j] = (preLeft + preSame) % mod;
                dp[i][j] = (dp[i][j] + preRight) % mod;
            }
        }
        int res = 0;
        for (int i = 0; i <= maxPos; i++) {
            res = Math.max(res, dp[steps][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.numWays(4, 2);
        System.out.println(res);
    }
}
