package com.liuyuyao.myproject.demo.半径为k的子数组平均值;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/30 下午4:04
 * @description：
 */
public class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = k; i < nums.length - k; i++) {
            ans[i] = (int) ((sum[i + k + 1] - sum[i - k]) / (2 * k + 1));
        }
        return ans;
    }
}
