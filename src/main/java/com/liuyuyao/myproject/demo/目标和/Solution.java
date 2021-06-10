package com.liuyuyao.myproject.demo.目标和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : mi
 * create at:  2021/6/7  上午11:18
 * @description: 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum - target + 2) % 2 == 1 || sum < target) {
            return 0;
        }
        int[][] dp = new int[nums.length][sum + 1];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i == 0) {
                dp[i][0]++;
                dp[i][curSum]++;
                continue;
            } else {
                for (int j = 0; j <= curSum; j++) {
                    dp[i][j] = nums[i] > j ? dp[i - 1][j] : dp[i - 1][j - nums[i]] + dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][(sum - target) / 2];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findTargetSumWays(new int[]{2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53}, 1000);
        System.out.println(res);
    }
}