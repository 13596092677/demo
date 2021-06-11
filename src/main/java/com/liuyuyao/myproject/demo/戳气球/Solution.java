package com.liuyuyao.myproject.demo.戳气球;

/**
 * @author : mi
 * create at:  2021/6/11  上午11:26
 * @description: 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 *  
 *
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0] * nums[1];
        for (int i = 1; i < nums.length; i++) {
            int left = i - 1 < 0 ? 1 : nums[i - 1];
            int right = i + 1 >= nums.length ? 1 : nums[i + 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + left * nums[i] * right;
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(res);
    }
}