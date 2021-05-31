package com.liuyuyao.myproject.demo.划分为k个相等的子集;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/5/31  下午2:26
 * @description: 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (max > target) {
            return false;
        }
        int[] visited = new int[nums.length];
        return dfs(nums, nums.length - 1, k, 0, target, visited);
    }

    boolean dfs(int[] nums, int index, int k, int curSum, int target, int[] visited) {
        if (k == 1) {
            return true;
        }
        if (target == curSum) {
            return dfs(nums, nums.length - 1, k - 1, 0, target, visited);
        }
        for (int i = index; i >= 0; i--) {
            if(visited[i] == 1) continue;
            if(curSum+nums[i] > target) continue;
            visited[i] = 1;
            if(dfs(nums, i- 1, k, curSum + nums[i], target, visited)){
                return true;
            }
            visited[i] = 0;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }
        return false;
    }
}