package com.liuyuyao.myproject.demo.最大单词长度乘积;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 2:50 下午
 * @description：
 */
public class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                // 判断当前字符是否已存在过，若存在过则跳过
                if ((mask[i] >> words[i].charAt(j) - 'a' & 1) == 0) {
                    mask[i] += Math.pow(2, words[i].charAt(j) - 'a');
                }
            }
        }
        int res = 0;
        for (int i = 0; i < mask.length; i++) {
            for (int j = i + 1; j < mask.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProduct(new String[]{"a","aa","aaa","aaaa"});
        System.out.println(res);
    }
}
