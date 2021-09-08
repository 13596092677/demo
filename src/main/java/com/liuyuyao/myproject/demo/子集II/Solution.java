package com.liuyuyao.myproject.demo.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 4:20 下午
 * @description：
 */
public class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, nums, 0);
        return ans;
    }

    void dfs(boolean choosePre, int[] nums, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        dfs(false, nums, idx + 1);
        if (!choosePre && idx > 0 && nums[idx - 1] == nums[idx]) {
            return;
        }
        subset.add(nums[idx]);
        dfs(true, nums, idx + 1);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsetsWithDup(new int[]{1, 2, 3, 3});
        System.out.println(res);
    }
}
