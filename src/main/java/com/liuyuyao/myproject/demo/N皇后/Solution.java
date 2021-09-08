package com.liuyuyao.myproject.demo.N皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 10:22 上午
 * @description：
 */
public class Solution {
    List<String> queen = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    List<Integer> pos = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(0, n);
        return ans;
    }

    void dfs(int idx, int n) {
        if (idx == n) {
            ans.add(new ArrayList<>(queen));
            return;
        }
        // 对每一行进行遍历
        for (int i = 0; i < n; i++) {
            // 判断当前位置是否有效
            if (!isValid(idx, i)) {
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            sb.setCharAt(i, 'Q');
            pos.add(i);
            queen.add(sb.toString());
            dfs(idx + 1, n);
            queen.remove(queen.size() - 1);
            pos.remove(pos.size() - 1);
        }
    }

    boolean isValid(int level, int curr) {
        for (int i = 0; i < pos.size(); i++) {
            // 同列冲突
            if (curr == pos.get(i)) {
                return false;
            }
            // 斜线冲突
            if (Math.abs(level - i) == Math.abs(curr - pos.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(5);
        System.out.println(res);
    }
}
