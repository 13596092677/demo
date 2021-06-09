package com.liuyuyao.myproject.demo.盈利计划;

/**
 * @author : mi
 * create at:  2021/6/9  下午3:32
 * @description: 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int m = group.length;
        int[][][] dp = new int[m][n + 1][minProfit + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (i == 0) {
                        // 当工作i可选时
                        if (j >= group[0] && profit[0] >= k) {
                            // 如果剩余所需利润为0,那么有两种方案,选或者不选
                            if (k == 0) {
                                dp[i][j][k] = 2;
                                // 否则必须选择
                            } else {
                                dp[i][j][k] = 1;
                            }
                            // 当工作i不可选时
                        } else {
                            if (k == 0) {
                                // 如果剩余所需利润为0,那么只有一种方案,不选;
                                dp[i][j][k] = 1;
                                // 否则没有方案
                            } else {
                                dp[i][j][k] = 0;
                            }
                        }
                    } else {
                        // 当工作i可选时
                        if (j >= group[i]) {
                            // 如果当前工作i的利润大于所需利润,那么有两种方案,选或者不选
                            // 不选时剩余所需利润为0
                            if (profit[i] >= k) {
                                dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i]][0]) % mod;
                                // 如果当前工作i的利润小于所需利润,那么只有一种方案,选
                                //选择时剩余所需利润为k-profit[i]
                            } else {
                                dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i]][k - profit[i]]) % mod;
                            }
                            // 当工作i不可选时
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            }
        }
        return dp[m - 1][n][minProfit];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3});
        System.out.println(res);
    }
}