package com.liuyuyao.myproject.demo.回文子字符串的个数;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/26 下午9:47
 * @description：
 */
public class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            ++ans;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j == 1) {
                    dp[j][i] = s.charAt(i) == s.charAt(j) ? true : false;
                } else{
                    dp[j][i] = s.charAt(i) == s.charAt(j) ? dp[j + 1][i - 1] : false;
                }

                if (dp[j][i]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countSubstrings("aaa");
        System.out.println(res);
    }
}
