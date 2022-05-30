package com.liuyuyao.myproject.demo.验证外星语词典;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/17 上午9:37
 * @description：
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] masks = new int[26];
        for (int i = 0; i < order.length(); i++) {
            masks[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            boolean flag = false;
            for (int j = 0; j < length; j++) {
                if (masks[words[i].charAt(j) - 'a'] > masks[words[i + 1].charAt(j) - 'a']) {
                    return false;
                } else if (masks[words[i].charAt(j) - 'a'] < masks[words[i + 1].charAt(j) - 'a']) {
                    flag = true;
                    break;
                }
            }
            if (flag == false && length < words[i].length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz");
        System.out.println(res);
    }
}
