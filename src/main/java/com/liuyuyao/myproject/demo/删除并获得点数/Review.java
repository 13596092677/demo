package com.liuyuyao.myproject.demo.删除并获得点数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2021/6/6 9:07 上午
 * @description：
 */
public class Review {
    public int deleteAndEarn(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]] = cnt[nums[i]] + 1;
        }
        int[][] dp = new int[max + 1][2];
        for (int i = min; i <= max; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + i * cnt[i];
        }
        return Math.max(dp[max][0], dp[max][1]);
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.deleteAndEarn(new int[]{3, 1});
        System.out.println(res);
    }
}
