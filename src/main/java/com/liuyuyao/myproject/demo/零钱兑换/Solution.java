package com.liuyuyao.myproject.demo.零钱兑换;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/6/8  下午9:13
 * @description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0) {
                    if (j % coins[i] == 0) {
                        dp[i][j] = j / coins[i];
                    }
                } else {
                    int m = j / coins[i];
                    for (int k = 0; k <= m; k++) {
                        if (dp[i - 1][j - k * coins[i]] != -1) {
                            dp[i][j] = dp[i][j] == -1 ? dp[i - 1][j - k * coins[i]] + k : Math.min(dp[i][j], dp[i][j - k * coins[i]] + k);
                        }
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.coinChange(new int[]{2, 5, 10, 1}, 27);
        System.out.println(res);
    }
}