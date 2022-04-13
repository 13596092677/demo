package com.liuyuyao.myproject.demo.最长回文子序列;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/12 下午4:51
 * @description：
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 :
                            Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestPalindromeSubseq("bbbab");
        System.out.println(res);
    }
}
