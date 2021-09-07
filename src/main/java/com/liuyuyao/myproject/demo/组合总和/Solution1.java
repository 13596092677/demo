package com.liuyuyao.myproject.demo.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/6 5:28 下午
 * @description：
 */
public class Solution1 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> combine = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, combine, ans, target);
        return ans;
    }

    void dfs(int[] candidates, int idx, List<Integer> combine, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        // 不选当前位置元素
        dfs(candidates, idx + 1, combine, ans, target);
        // 选择当前位置元素
        if (target >= candidates[idx]) {
            combine.add(candidates[idx]);
            dfs(candidates, idx, combine, ans, target - candidates[idx]);
            combine.remove(combine.size() - 1);
        }
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<Integer>> res = solution1.combinationSum(new int[]{1,2,3},4);
        System.out.println(res);
    }
}
