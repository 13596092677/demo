package com.liuyuyao.myproject.demo.含有k个元素的组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 下午3:15
 * @description：
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    void dfs(int idx, int limit, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx == limit + 1) {
            return;
        }
        dfs(idx + 1, limit, k);
        list.add(idx);
        dfs(idx + 1, limit, k);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(4, 2);
        System.out.println(res);
    }
}
