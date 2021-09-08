package com.liuyuyao.myproject.demo.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 3:51 下午
 * @description：
 */
public class Solution {
    List<Integer> combine = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k);
        return ans;
    }

    void dfs(int idx, int cnt) {
        if (cnt == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (idx == 0) {
            return;
        }
        dfs(idx - 1, cnt);
        combine.add(idx);
        dfs(idx - 1, cnt - 1);
        combine.remove(combine.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(5, 2);
        System.out.println(res);
    }
}
