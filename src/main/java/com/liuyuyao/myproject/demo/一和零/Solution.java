package com.liuyuyao.myproject.demo.一和零;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author : mi
 * create at:  2021/6/8  下午4:55
 * @description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (i == 0) {
                            if (j >= count0(strs[i]) && k >= count1(strs[i])) {
                                dp[i][j][k] = 1;
                            } else {
                                dp[i][j][k] = 0;
                            }
                        } else {
                            if (j >= count0(strs[i]) && k >= count1(strs[i])) {
                                dp[i][j][k] = Math.max(dp[i - 1][j - count0(strs[i])][k - count1(strs[i])] + 1, dp[i - 1][j][k]);
                            } else {
                                dp[i][j][k] = dp[i - 1][j][k];
                            }
                        }
                    }
                }
        }
        return dp[strs.length - 1][m][n];
    }
    int count0(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res++;
            }
        }
        return res;
    }

    int count1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        System.out.println(res);
    }
}