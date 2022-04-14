package com.liuyuyao.myproject.demo.最长递增子序列的个数;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/13 下午11:47
 * @description：
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        // dp[i]表示以第i个数字结尾的最长上升子序列的长度
        // path[i]表示以第i个数字结尾的最长上升子序列的个数
        int[] dp = new int[nums.length];
        int[] path = new int[nums.length];
        // 初始值都设为1。因为长度和个数至少为1
        Arrays.fill(dp, 1);
        Arrays.fill(path, 1);
        // 设置最大长度变量和个数变量
        int maxLen = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                // 当扫描子序列长度不为1时
                if (j != i) {
                    // 当nums[i]>nums[j]时，nums[i]可以放到dp[j]的最长上升子序列后
                    if (nums[i] > nums[j]) {
                        // 以j结尾的最长上升子序列加入nums[i]超过dp[j]，则更新dp[i]
                        // 并重置path[i]，也就是以i结尾的最长上升子序列个数。重置后结果为path[j]，即以j结尾的子序列个数
                        if (dp[j] + 1 > dp[i]) {
                            path[i] = path[j];
                            dp[i] = dp[j] + 1;
                            // 如果和原有dp[j]相等，则不必更新dp[i]
                            // 但是需要增加至以i结尾的最长上升子序列个数。增加数量为path[j]
                            // 也就是说不需要更新最大值，但是需要扩充集合元素个数
                        } else if (dp[j] + 1 == dp[i]) {
                            path[i] += path[j];
                        }
                        // 每次更新需要和全局最大值作比较，因为dp[i]和path[i]中的最大上升子序列都是必须以第i个数字结尾的子序列
                        // 每次扫描其实进行了两次比较，dp[j]+1分别对dp[i]和maxLen进行了比较，对两个后者都要进行更新
                        if (dp[j] + 1 > maxLen) {
                            ans = path[j];
                            maxLen = dp[j] + 1;
                        } else if (dp[j] + 1 == maxLen) {
                            ans += path[j];
                        }
                    }
                    // 当扫描子序列长度为1时
                } else {
                    if (maxLen == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(res);
    }
}
