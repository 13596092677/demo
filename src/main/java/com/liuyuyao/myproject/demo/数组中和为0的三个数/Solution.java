package com.liuyuyao.myproject.demo.数组中和为0的三个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 下午11:20
 * @description：
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, 0,false);
        return ans;
    }

    void dfs(int[] nums, int idx, int target, boolean choosePre) {
        if (list.size() == 3 && target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx == nums.length) {
            return;
        }
        dfs(nums, idx + 1, target, false);
        if (!choosePre && idx > 0 && nums[idx] == nums[idx - 1]) {
            return;
        }
        list.add(nums[idx]);
        dfs(nums, idx + 1, target - nums[idx], true);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
