package com.liuyuyao.myproject.demo.计算各个位数不同的数字个数;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/17 11:45 下午
 * @description：
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * 10 + (9 * (int) Math.pow(10, i - 2) - dp[i - 1]) * (i - 1);
        }
        sum = Arrays.stream(dp).sum();
        return (int) Math.pow(10, n) - sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countNumbersWithUniqueDigits(3);
        System.out.println(res);
        int a = 0;
        System.out.println(~a);
        System.out.println(Integer.toBinaryString(~a));
    }
}
