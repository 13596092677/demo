package com.liuyuyao.myproject.demo.得分最高的单词集合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 3:45 下午
 * @description：
 */
public class Solution {
    int ans;
    // 每个单词的字母评分和
    int[] wordScores;
    // 单词的字母数量集合
    int[][] stringLetterCount;
    // 调试用
    List<String> debugString = new ArrayList<>();
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        wordScores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordScores[i] += score[words[i].charAt(j) - 'a'];
            }
        }

        stringLetterCount = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                stringLetterCount[i][words[i].charAt(j) - 'a']++;
            }
        }

        int[] letterCount = new int[26];
        for (int i = 0; i < letters.length; i++) {
            letterCount[letters[i] - 'a']++;
        }
        dfs(words, letterCount, 0, 0);
        return ans;
    }

    void dfs(String[] words, int[] letterCount, int idx, int sum) {
        if (idx == words.length) {
            System.out.println(debugString);
            ans = Math.max(ans, sum);
            return;
        }
        if (isValid(idx, letterCount)) {
            // choose(words[idx]);
            debugString.add(words[idx]);
            for (int i = 0; i < 26; i++) {
                if (stringLetterCount[idx][i] != 0) {
                    letterCount[i] -= stringLetterCount[idx][i];
                }
            }
            dfs(words, letterCount, idx + 1, sum + wordScores[idx]);
            for (int i = 0; i < 26; i++) {
                if (stringLetterCount[idx][i] != 0) {
                    letterCount[i] += stringLetterCount[idx][i];
                }
            }
            debugString.remove(debugString.size() - 1);
        }
        dfs(words, letterCount, idx + 1, sum);
    }

    boolean isValid(int idx, int[] letterCount) {
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] < stringLetterCount[idx][i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxScoreWords(new String[]{"dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(res);
    }
}
