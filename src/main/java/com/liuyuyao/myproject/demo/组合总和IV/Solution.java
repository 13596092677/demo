package com.liuyuyao.myproject.demo.组合总和IV;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 10:06 上午
 * @description：
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(res);
    }
}
