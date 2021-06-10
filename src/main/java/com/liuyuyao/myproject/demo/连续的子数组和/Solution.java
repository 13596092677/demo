package com.liuyuyao.myproject.demo.连续的子数组和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : mi
 * create at:  2021/6/7  下午7:43
 * @description: 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][sum + 1];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i == 0) {
                dp[0][nums[i]]++;
            } else {
                for (int j = nums[i]; j <= curSum; j++) {
                    if (j == nums[i]) {
                        dp[i][j] = dp[i - 1][j - nums[i]] > 0 ? 1 + dp[i - 1][j - nums[i]] : 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - nums[i]] > 0 ? 1 + dp[i - 1][j - nums[i]] : 0;
                    }
                    if (j % k == 0 && dp[i][j] >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // 前缀和+哈希表
    public boolean checkSubarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int modSum = 0;
        for (int i = 0; i < nums.length; i++) {
            modSum = (modSum + nums[i]) % k;
            if (map.containsKey(modSum)) {
                if (i + 1 - map.get(modSum) >= 2) {
                    return true;
                }
            } else {
                map.put(modSum, i + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.checkSubarraySum1(new int[]{2, 4, 3}, 6);
        System.out.println(res);

    }
}