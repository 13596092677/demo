package com.liuyuyao.myproject.demo.优美的排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/9 11:21 下午
 * @description：
 */
public class Solution {
    // 因为本题答案是返回数量，所以并不需要以下容器
    // 加入是为了调试结果
    List<Integer> arrangement = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        return dfs(n, 0, visited);
    }

    int dfs(int n, int idx, boolean[] visited) {
        if (idx == n) {
            ans.add(new ArrayList<>(arrangement));
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) {
                continue;
            }
            if ((idx + 1) % i == 0 || i % (idx + 1) == 0) {
                arrangement.add(i);
                visited[i - 1] = true;
                res += dfs(n, idx + 1, visited);
                arrangement.remove(arrangement.size() - 1);
                visited[i - 1] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countArrangement(9);
        System.out.println(res);
    }
}
