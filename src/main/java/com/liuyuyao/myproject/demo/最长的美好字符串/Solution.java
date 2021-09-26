package com.liuyuyao.myproject.demo.最长的美好字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/23 5:37 下午
 * @description：
 */
public class Solution {
    int len;
    String ans = "";
    public String longestNiceSubstring(String s) {
        dfs(s, 0, s.length());
        return ans;
    }

    void dfs(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            set.add(s.charAt(i));
        }
        char ch = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (!isValid((char) i, set)) {
                ch = (char) i;
                break;
            }
        }
        if (ch == 0) {
            if (end - start > len) {
                len = end - start;
                ans = s.substring(start, end);
            }
            return;
        }
        int i = start;
        int res = 0;
        while (i < end) {
            while (i < end && (s.charAt(i) == Character.toLowerCase(ch) || s.charAt(i) == Character.toUpperCase(ch))) {
                i++;
            }
            int left = i;
            while (i < end && (s.charAt(i) != Character.toLowerCase(ch) && s.charAt(i) != Character.toUpperCase(ch))) {
                i++;
            }
            dfs(s, left, i);
        }
    }

    boolean isValid(char ch, Set<Character> hashSet) {
        if (!hashSet.contains(Character.toLowerCase(ch)) && !hashSet.contains(Character.toUpperCase(ch))) {
            return true;
        }
        if (hashSet.contains(Character.toLowerCase(ch)) && hashSet.contains(Character.toUpperCase(ch))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.longestNiceSubstring("YazaAay");
        System.out.println(ans);
    }
}
