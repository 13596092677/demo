package com.liuyuyao.myproject.demo.零钱兑换II;

import javax.jws.soap.SOAPBinding;

/**
 * @author : mi
 * create at:  2021/6/10  下午2:45
 * @description:
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0) {
                    if (j % coins[i] == 0) {
                        dp[i][j] = 1;
                    }
                } else {
                    int m = j / coins[i];
                    for (int k = 0; k <= m; k++) {
                        dp[i][j]+= dp[i - 1][j - k * coins[i]] ;
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 对于每种总金额, 必须按照coins[]顺序遍历
        // 比如测试用例中,先取面额为1,再取面额为2,以此类推
        // 如果两层循环顺序颠倒,会出现例如 1+2和2+1计算为两种方案的情况
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.change(5, new int[]{1, 2, 5});
        System.out.println(res);
    }
}