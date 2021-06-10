package com.liuyuyao.myproject.demo.最后一块石头的重量II;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/6/8  下午2:44
 * @description: 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int[][] dp = new int[stones.length][sum / 2 + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (i == 0) {
                    dp[i][j] = j >= stones[i] ? stones[i] : 0;
                } else {
                    dp[i][j] = j >= stones[i] ? Math.max(dp[i - 1][j - stones[i]] + stones[i], dp[i - 1][j]) : dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[stones.length - 1][sum / 2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lastStoneWeightII(new int[]{57,32,40,27,35,61});
        System.out.println( res);
    }
}