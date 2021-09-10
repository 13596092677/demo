package com.liuyuyao.myproject.demo.所有可能的路径;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/10 11:18 上午
 * @description：
 */
public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        dfs(graph, visited, graph.length, 0);
        return ans;
    }

    void dfs(int[][] graph, boolean[] visited, int length, int idx) {
        if (idx == length - 1) {
            path.add(idx);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (visited[idx]) {
            return;
        }
        for (int i = 0; i < graph[idx].length; i++) {
            path.add(idx);
            visited[idx] = true;
            dfs(graph, visited, length, graph[idx][i]);
            path.remove(path.size() - 1);
            visited[idx] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        System.out.println(res);
    }
}
