package com.liuyuyao.myproject.demo.最长重复子数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/25 下午9:59
 * @description：
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int ans = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
