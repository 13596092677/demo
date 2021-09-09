package com.liuyuyao.myproject.demo.火柴拼正方形;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/9 8:51 下午
 * @description：
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        boolean[] visited = new boolean[matchsticks.length];
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return dfs(matchsticks, visited, 4, sum / 4, sum / 4);
    }

    boolean dfs(int[] matchsticks, boolean[] visited, int cnt, int sum, int target) {
        if (target == 0) {
            cnt--;
            target = sum;
        }
        if (cnt == 1) {
            return true;
        }
        for (int i = matchsticks.length - 1; i >= 0; i--) {
            if (visited[i]) {
                continue;
            }
            if (target >= matchsticks[i]) {
                visited[i] = true;
                boolean res = dfs(matchsticks, visited, cnt, sum, target - matchsticks[i]);
                visited[i] = false;
                if (res) {
                    return true;
                }
            }
            while (i > 0 && matchsticks[i] == matchsticks[i - 1]) {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.makesquare(new int[]{3, 3, 3, 3, 4});
        System.out.println(res);
    }
}
