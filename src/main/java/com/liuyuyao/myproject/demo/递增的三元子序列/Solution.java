package com.liuyuyao.myproject.demo.递增的三元子序列;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/13 下午7:27
 * @description：
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j < i; j++) {
                dp[i] = Math.max(dp[i], nums[j] < nums[i] ? dp[j] + 1 : 1);
            }
            if (dp[i] == 3) {
                return true;
            }
        }
        return false;
    }


}
