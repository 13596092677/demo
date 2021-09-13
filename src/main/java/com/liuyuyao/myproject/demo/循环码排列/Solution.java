package com.liuyuyao.myproject.demo.循环码排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/12 9:10 上午
 * @description：
 */
public class Solution {
    List<Integer> temp = new ArrayList<>();
    List<Integer> ans;
    public List<Integer> circularPermutation(int n, int start) {
        boolean[] visited = new boolean[(int)Math.pow(2,n)];
        temp.add(start);
        visited[start] = true;
        dfs(n, 1, start, start, visited);
        temp.remove(temp.size() - 1);
        visited[start] = false;
        return ans;
    }

    boolean dfs(int n, int idx, int last, int start, boolean[] visited) {
        if (idx == (int) Math.pow(2, n)) {
            if (isValid(last, start, n)) {
                ans = new ArrayList<>(temp);
                return true;
            }
            return false;
        }
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            if (visited[i]) {
                continue;
            }
            if (isValid(i, last, n)) {
                temp.add(i);
                visited[i] = true;
                boolean res = dfs(n, idx + 1, i, start, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isValid(int src, int target, int bitCount) {
        for (int i = 0; i < bitCount; i++) {
            if ((src ^ (1 << i)) == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.circularPermutation(2, 3);
        System.out.println(res);
    }
}
