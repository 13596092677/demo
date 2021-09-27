package com.liuyuyao.myproject.demo.找出最长的超赞子字符串;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/27 11:00 上午
 * @description：
 */
public class Solution {
    public int longestAwesome(String s) {
        int mask = 0;
        // dp[i]存储的是状态为i的字符串下标+1 (!!!!!!!!)
        int[] dp = new int[1 << 10];
        // 初始值设置为-1，表示没有该状态。需要设置为-1，否则会出现混淆情况。比如dp[i]=0，不能区分是下标为0，还是没有该状态
        Arrays.fill(dp, -1);
        int ans = 0;
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= 1 << s.charAt(i) - '0';
            // 先遍历所有和状态与mask相差一位的情况。即子串有1种字母为奇数，其余字母为偶数的情况
            for (int j = 0; j < 10; j++) {
                if (dp[mask ^ 1 << j] == -1) {
                    continue;
                }
                ans = Math.max(ans, i - dp[mask ^ 1 << j] + 1);
            }
            // 然后计算和mask状态相同的情况。即子串所有字母都为偶数的情况
            if (dp[mask] == -1) {
                dp[mask] = i + 1;
            } else{
                ans = Math.max(ans, i - dp[mask] + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestAwesome("76263");
        System.out.println(res);
    }
}
