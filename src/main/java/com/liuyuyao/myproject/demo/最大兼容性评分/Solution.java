package com.liuyuyao.myproject.demo.最大兼容性评分;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 10:25 上午
 * @description：
 */
public class Solution {
    int ans;
    int curr;
    List<Integer> debugList = new ArrayList<>();
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        int[][] scores = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    scores[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        boolean[] visited = new boolean[m];
        dfs(scores, visited, 0);
        return ans;
    }

    void dfs(int[][] scores, boolean[] visited, int idx) {
        if (idx == scores.length) {
            ans = Math.max(ans, curr);
            System.out.println(debugList);
            return;
        }
        for (int i = 0; i < scores.length; i++) {
            if (visited[i]) {
                continue;
            }
            curr += scores[idx][i];
            debugList.add(i);
            visited[i] = true;
            dfs(scores, visited, idx + 1);
            debugList.remove(debugList.size() - 1);
            visited[i] = false;
            curr -= scores[idx][i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxCompatibilitySum(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}}, new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}});
        System.out.println(res);

    }
}
