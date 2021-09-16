package com.liuyuyao.myproject.demo.构建字典序最大的可行序列;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/13 9:17 下午
 * @description：
 */
public class Solution {
    List<Integer> sequence = new ArrayList<>();
    List<Integer> ans;
    int[] copy;
    public int[] constructDistancedSequence(int n) {
        copy = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            sequence.add(-1);
        }
        dfs(n, visited, 0);
        for (int i = 0; i < ans.size(); i++) {
            copy[i] = ans.get(i);
        }
        return copy;
    }

    boolean dfs(int n, boolean[] visited, int len) {
        if (len == 2 * n - 1) {
            ans = new ArrayList<>(sequence);
            System.out.println(ans);
            return true;
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            // 找到某一位置没有放过数
            if (sequence.get(i) != -1) {
                continue;
            }
            for (int j = n; j > 0; j--) {
                if (visited[j]) {
                    continue;
                }
                if (j == 1) {
                    sequence.set(i, j);
                    visited[j] = true;
                    boolean res = dfs(n, visited, len + 1);
                    sequence.set(i, -1);
                    visited[j] = false;
                    if (res) {
                        return true;
                    }
                } else{
                    if (i + j >= 2 * n - 1) {
                        continue;
                    }
                    if (sequence.get(i + j) != -1) {
                        continue;
                    }
                    sequence.set(i, j);
                    sequence.set(i + j, j);
                    visited[j] = true;
                    boolean res = dfs(n, visited, len + 2);
                    sequence.set(i, -1);
                    sequence.set(i + j, -1);
                    visited[j] = false;
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.constructDistancedSequence(17);
        System.out.println(res);
    }
}
