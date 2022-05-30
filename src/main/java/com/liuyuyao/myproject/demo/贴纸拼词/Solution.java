package com.liuyuyao.myproject.demo.贴纸拼词;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/14 下午12:00
 * @description：
 */
public class Solution {
    public int minStickers(String[] stickers, String target) {
        int[][] cnts = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                cnts[i][c - 'a']++;
            }
        }
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < stickers.length; i++) {
            // 对于target的每一个子集j进行遍历。
            // 将target用target.length()个二进制1表示，其值为(1<<target.length())-1
            // 那么0≤j≤(1<<target.length())-1就可以表示target任何一个子集
            for (int j = 1; j < 1 << target.length(); j++) {
                int[] copy = Arrays.copyOf(cnts[i], 26);
                int left = j;
                for (int k = 0; k < target.length(); k++) {
                    char ch = target.charAt(k);
                    // 当j包含target的第k位，且当前位可以由stickers[i]提供时,作差集
                    if ((left >> k & 1) == 1 && copy[ch - 'a'] > 0) {
                        // 这里注意不可以使用left &=0 <<k;
                        // 因为上述操作会将其他状态位也置为0
                        left ^= 1 << k;
                        copy[ch - 'a']--;
                    }
                }
                if (left != j) {
                    if (dp[left] != -1) {
                        dp[j] = dp[j] == -1 ? dp[left] + 1 : Math.min(dp[j], dp[left] + 1);
                    }
                }
            }
        }
        return dp[(1 << target.length()) - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minStickers(new String[]{"with", "example", "science"}, "thehat");
        System.out.println(res);
    }
}
