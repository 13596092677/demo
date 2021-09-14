package com.liuyuyao.myproject.demo.找出所有子集的异或总和再求和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 12:38 下午
 * @description：
 */
public class Solution {
    int ans;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    void dfs(int[] nums, int idx, int sum) {
        if (nums.length == idx) {
            ans += sum;
            return;
        }
        dfs(nums, idx + 1, sum);
        dfs(nums, idx + 1, sum ^ nums[idx]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.subsetXORSum(new int[]{1, 3});
        System.out.println(res);
    }
}
