package com.liuyuyao.myproject.demo.最长回文子序列;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/18 上午10:18
 * @description：
 */
public class Review {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.longestPalindromeSubseq("bbbab");
        System.out.println(res);
    }
}
