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
    public int[] constructDistancedSequence(int n) {
        int[] rest = new int[n + 1];
        int[] last = new int[n + 1];
        int[] copy = new int[2 * n - 1];
        Arrays.fill(rest, 2);
        rest[1] = 1;
        Arrays.fill(last, -1);
        dfs(n, 0, rest, last);
        for (int i = 0; i < ans.size(); i++) {
            copy[i] = ans.get(i);
        }
        return copy;
    }

    boolean dfs(int n, int idx, int[] rest, int[] last) {
        if (idx == 2 * n - 1) {
            ans = new ArrayList<>(sequence);
            System.out.println(ans);
            return true;
        }
        for (int i = n; i > 0; i--) {
            if (rest[i] > 0 && (last[i] == -1 || Math.abs(last[i] - idx) == i)) {
                int copy = last[i];
                rest[i] = rest[i] - 1;
                last[i] = idx;
                sequence.add(i);
                boolean res = dfs(n, idx + 1, rest, last);
                rest[i] = rest[i] + 1;
                last[i] = copy;
                sequence.remove(sequence.size() - 1);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.constructDistancedSequence(12);
        System.out.println(res);
    }
}
