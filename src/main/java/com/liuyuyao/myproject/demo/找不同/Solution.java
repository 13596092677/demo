package com.liuyuyao.myproject.demo.找不同;

import java.text.CharacterIterator;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 10:46 下午
 * @description：
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int maskS = 0, maskT = 0;
        for (int i = 0; i < s.length(); i++) {
            maskS ^= 1 << s.charAt(i) - 'a';
        }
        for (int i = 0; i < t.length(); i++) {
            maskT ^= 1 << t.charAt(i) - 'a';
        }
        int res = maskS ^ maskT;
        char ch = 'a';
        for (int i = 0; i < 26; i++) {
            if ((res >> i & 1) == 1) {
                ch = (char) ('a' + i);
                return ch;
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char res = solution.findTheDifference("ae", "aea");
        System.out.println(res);
    }
}
