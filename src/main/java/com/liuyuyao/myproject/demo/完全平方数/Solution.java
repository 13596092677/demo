package com.liuyuyao.myproject.demo.完全平方数;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/6/11  上午10:22
 * @description:
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; Math.pow(j, 2) <= i; j++) {
                dp[i] = dp[i] == -1 ? dp[i - (int) Math.pow(j, 2)] + 1 : Math.min(dp[i], dp[i - (int) Math.pow(j, 2)] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSquares(12);
        System.out.println(res);
    }
}