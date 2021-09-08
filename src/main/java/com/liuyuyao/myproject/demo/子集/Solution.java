package com.liuyuyao.myproject.demo.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 4:13 下午
 * @description：
 */
public class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    void dfs(int[] nums, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        dfs(nums, idx + 1);
        subset.add(nums[idx]);
        dfs(nums, idx + 1);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(new int[]{1});
        System.out.println(res);
    }
}
