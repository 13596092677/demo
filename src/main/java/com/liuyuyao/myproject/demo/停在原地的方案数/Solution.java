package com.liuyuyao.myproject.demo.停在原地的方案数;

/**
 * @author : mi
 * create at:  2021/6/1  下午2:21
 * @description: 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = (int) Math.pow(10, 9) + 7;
        int maxPos = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][maxPos + 1];
        dp[0][0] = 1;
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j <= Math.min(maxPos, i); j++) {
                int preLeft = (i >= j && j - 1 >= 0 ? dp[i - 1][j - 1] : 0) % mod;
                int preSame = dp[i - 1][j] % mod;
                int preRight = (i - 2 >= j && j + 1 <= maxPos ? dp[i - 1][j + 1] : 0) % mod;
                dp[i][j] = ((preLeft + preSame) % mod + preRight) % mod;
            }
        }
        return dp[steps][0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numWays(27, 7);
        System.out.println(res);
    }
}