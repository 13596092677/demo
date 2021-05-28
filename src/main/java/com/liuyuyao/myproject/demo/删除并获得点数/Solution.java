package com.liuyuyao.myproject.demo.删除并获得点数;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/5/27  下午8:43
 * @description: 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10000];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            max = Math.max(max, nums[i]);
        }
        int[][] dp = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + cnt[i] * i;
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.deleteAndEarn(new int[]{3, 4, 2});
        System.out.println(res);
    }
}