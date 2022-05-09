package com.liuyuyao.myproject.demo.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/6 下午5:11
 * @description：
 */
public class Review1 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target,false);
        return ans;
    }

    void dfs(int[] nums, int idx, int target, boolean choosePre) {
        if (target == 0) {
            if (choosePre && idx > 0 && idx < nums.length && nums[idx] == nums[idx - 1]) {
            } else {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (idx == nums.length) {
            return;
        }


        if (nums[idx] <= target) {
            list.add(nums[idx]);
            dfs(nums, idx + 1, target - nums[idx], true);
            list.remove(list.size() - 1);
        }

        if (choosePre && idx > 0 && nums[idx] == nums[idx - 1]) {
            return;
        }
        dfs(nums, idx + 1, target, false);
    }

    public static void main(String[] args) {
        Review1 review1 = new Review1();
        List<List<Integer>> res = review1.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(res);

    }
}
