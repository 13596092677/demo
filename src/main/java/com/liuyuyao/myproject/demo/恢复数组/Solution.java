package com.liuyuyao.myproject.demo.恢复数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/11 下午10:17
 * @description：
 */
public class Solution {
    public int numberOfArrays(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        if (Integer.parseInt(s.substring(0, 1)) <= k && Integer.parseInt(s.substring(0, 1)) != 0) {
            dp[0][0] = 1;
        } else{
            dp[0][0] = 0;
        }
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[0][i] += dp[0][j] * dp[j + 1][i];
            }
        }
        return dp[0][s.length()];
    }
}
