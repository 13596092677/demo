package com.liuyuyao.myproject.demo.单词接龙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 4:51 下午
 * @description：
 */
public class Solution {
    int len=Integer.MAX_VALUE;
    List<String> ladder = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return ans;
        }
        boolean[] visited = new boolean[wordList.size()];
        ladder.add(beginWord);
        dfs(wordList, visited, endWord, beginWord, 1);
        ladder.remove(ladder.size() - 1);
        return ans;
    }

    void dfs(List<String> wordList, boolean[] visited, String endWord, String lastWord, int idx) {
        if (idx > len) {
            return;
        }
        if (ladder.get(ladder.size() - 1).equals(endWord)) {
            System.out.println(ladder);
            if (ladder.size() == len) {
                ans.add(new ArrayList<>(ladder));
            } else if (ladder.size() < len) {
                Iterator<List<String>> iterator = ans.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().size() == len) {
                        iterator.remove();
                    }
                }
                ans.add(new ArrayList<>(ladder));
                len = ladder.size();
            }
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            if (isValid(wordList.get(i), lastWord)) {
                ladder.add(wordList.get(i));
                visited[i] = true;
                dfs(wordList, visited, endWord, wordList.get(i), idx + 1);
                ladder.remove(ladder.size() - 1);
                visited[i] = false;
            }
        }
    }

    boolean isValid(String s, String lastWord) {
        if (s.length() != lastWord.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != lastWord.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
