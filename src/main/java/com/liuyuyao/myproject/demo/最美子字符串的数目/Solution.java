package com.liuyuyao.myproject.demo.最美子字符串的数目;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/23 3:44 下午
 * @description：
 */
public class Solution {
    public long wonderfulSubstrings(String word) {
        // dp[mask]对应每种状态对应的子串数量(从头开始的子串)
        long[] dp = new long[1 << 10];
        int status = 0;
        long ans = 0;
        dp[0] = 1;
        for (int i = 0; i < word.length(); i++) {
            status ^= 1 << word.charAt(i) - 'a';
            // 每个字母都出现偶数次的子串个数
            ans += dp[status];
            // 有一个字母出现奇数次的子串个数
            for (int j = 0; j < 10; j++) {
                ans += dp[status ^ 1 << j];
            }
            dp[status] += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.wonderfulSubstrings("aabb");
        System.out.println(res);
        System.out.println("commit1");
    }
}
