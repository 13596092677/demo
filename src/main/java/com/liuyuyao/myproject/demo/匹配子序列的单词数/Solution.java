package com.liuyuyao.myproject.demo.匹配子序列的单词数;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/14 下午4:25
 * @description：
 */
public class Solution {
    // 超时做法
    // 思想：将每一个word和s计算最长公共子序列长度，若等于word长度，则满足条件，ans+1
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            int[][] dp = new int[s.length() + 1][word.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= word.length(); j++) {
                    dp[i][j] = s.charAt(i - 1) == word.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            if (dp[s.length()][word.length()] == word.length()) {
                ans++;
            }
        }
        return ans;
    }


    public int numMatchingSubseq1(String s, String[] words) {
        int ans = 0;
        List<List<String>> heads = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            heads.add(new ArrayList<String>());
        }
        for (String word : words) {
            List<String> list = heads.get(word.charAt(0) - 'a');
            list.add(word);
        }
        for (char ch : s.toCharArray()) {
            List<String> list = heads.get(ch - 'a');
            for (int i = list.size() - 1; i >= 0; i--) {
                String str = list.get(i).substring(1);
                list.remove(i);
                if (str.length() == 0) {
                    ans++;
                    continue;
                }
                heads.get(str.charAt(0) - 'a').add(str);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numMatchingSubseq1("abcde", new String[]{"a", "bb", "acd", "ace"});
        System.out.println(res);
    }
}
