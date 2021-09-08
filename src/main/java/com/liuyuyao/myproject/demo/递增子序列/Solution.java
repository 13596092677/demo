package com.liuyuyao.myproject.demo.递增子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 5:22 下午
 * @description：
 */
public class Solution {
    List<Integer> subSequence = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(Integer.MIN_VALUE, nums, 0);
        return ans;
    }

    void dfs(int last, int[] nums, int cnt) {
        if (nums.length == cnt) {
            if (subSequence.size() >= 2) {
                ans.add(new ArrayList<>(subSequence));
            }
            return;
        }
        if (nums[cnt] >= last) {
            subSequence.add(nums[cnt]);
            dfs(nums[cnt], nums, cnt + 1);
            subSequence.remove(subSequence.size() - 1);
        }
        if (nums[cnt] != last) {
            dfs(last, nums, cnt + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.findSubsequences(new int[]{1,1,1});
        System.out.println(res);
    }
}
