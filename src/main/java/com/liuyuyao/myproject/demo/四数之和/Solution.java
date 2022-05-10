package com.liuyuyao.myproject.demo.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 上午11:34
 * @description：
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, 0, 0, target, false);
        return ans;
    }

    void dfs(int[] nums, int idx, int k, int target, boolean choosePre) {
        if (k == 4) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (idx == nums.length) {
            return;
        }
        dfs(nums, idx + 1, k, target, false);
        if (!choosePre && idx > 0 && nums[idx] == nums[idx - 1]) {
            return;
        }
        list.add(nums[idx]);
        dfs(nums, idx + 1, k + 1, target - nums[idx], true);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(res);
    }
}
