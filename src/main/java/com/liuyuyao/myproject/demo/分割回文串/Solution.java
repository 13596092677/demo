package com.liuyuyao.myproject.demo.分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 9:06 下午
 * @description：
 */
public class Solution {
    List<String> temp = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }

    void dfs(String s, int idx) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValidPalindrome(sb.toString())) {
                temp.add(sb.toString());
                dfs(s, idx + sb.length());
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isValidPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.partition("aabbc");
        System.out.println(res);
    }
}
