package com.liuyuyao.myproject.demo.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/6 6:31 下午
 * @description：
 */
public class Solution1 {
    List<Integer> combine = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(false, candidates, 0, combine, ans, target);
        return ans;
    }

    void dfs(boolean choosePre, int[] candidates, int idx, List<Integer> combine, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        dfs(false, candidates, idx + 1, combine, res, target);
        if (!choosePre && idx > 0 && candidates[idx - 1] == candidates[idx]) {
            return;
        }
        if (target >= candidates[idx]) {
            combine.add(candidates[idx]);
            dfs(true, candidates, idx + 1, combine, res, target - candidates[idx]);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<Integer>> res = solution1.combinationSum2(new int[]{2, 5, 2, 1, 2}, 8);
        System.out.println(res);
    }
}
