package com.liuyuyao.myproject.demo.单词长度的最大乘积;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/29 11:47 下午
 * @description：
 */
public class Solution {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                mask |= 1 << ch - 'a';
            }
            masks[i] = mask;
            lengths[i] = words[i].length();
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, lengths[i] * lengths[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProduct(new String[]{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"});
        System.out.println(res);
    }
}
