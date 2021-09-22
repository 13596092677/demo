package com.liuyuyao.myproject.demo.格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 11:10 上午
 * @description：
 */
public class Solution {
    List<Integer> ans;
    List<Integer> code = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        boolean[] visited = new boolean[1 << n];
        visited[0] = true;
        code.add(0);
        dfs(1 << n, 0, 1, visited);
        visited[0] = false;
        code.remove(code.size() - 1);
        return ans;
    }

    boolean dfs(int n, int status, int idx, boolean[] visited) {
        if (idx == n) {
            ans = new ArrayList<>(code);
            return true;
        }
        for (int i = 0; i < 1 << n; i++) {
            if (visited[i]) {
                continue;
            }
            if (check(status, i, n)) {
                visited[i] = true;
                code.add(i);
                boolean res = dfs(n, i, idx + 1, visited);
                visited[i] = false;
                code.remove(code.size() - 1);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean check(int status, int curr, int bit) {
        int res = status ^ curr;
        int cnt = 0;
        for (int i = 0; i < bit; i++) {
            if ((res >> i & 1) == 1) {
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.grayCode(3);
        System.out.println(res);
    }
}
