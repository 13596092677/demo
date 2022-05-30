package com.liuyuyao.myproject.demo.不同的子序列;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/26 下午4:20
 * @description：
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < t.length() + 1; j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j] + dp[i - 1][j - 1] : dp[i - 1][j - 1];
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numDistinct("rabbbit", "rabbit");
        System.out.println(res);
    }
}
