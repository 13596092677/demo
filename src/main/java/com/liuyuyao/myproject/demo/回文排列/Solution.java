package com.liuyuyao.myproject.demo.回文排列;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/29 4:28 下午
 * @description：
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        long front = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 64) {
                end ^= 1L << s.charAt(i) - 64;
            } else {
                front ^= 1L << s.charAt(i);
            }
        }
        return Long.bitCount(front) + Long.bitCount(end) <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canPermutePalindrome("AaBb//a");
        System.out.println(res);
    }
}
