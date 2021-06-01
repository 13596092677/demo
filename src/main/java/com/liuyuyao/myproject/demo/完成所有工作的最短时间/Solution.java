package com.liuyuyao.myproject.demo.完成所有工作的最短时间;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/5/28  上午11:15
 * @description: 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k, int limit) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] visited = new int[nums.length];
        return dfs(nums, nums.length - 1, k, 0, limit, visited);
    }

    boolean dfs(int[] nums, int index, int k, int curSum, int limit, int[] visited) {
        if (k == 1) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[1] == 0) {
                    sum+=nums[i];
                }
            }
            if (sum > limit) {
                return false;
            } else{
                return true;
            }
        }
        for (int i = index; i >= 0; i--) {
            if(visited[i] == 1) continue;
            if(curSum+nums[i] > limit) continue;
            visited[i] = 1;
            if(dfs(nums, i- 1, k, curSum + nums[i], limit, visited)){
                return true;
            }
            visited[i] = 0;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canPartitionKSubsets(new int[]{1, 2, 4, 7, 8}, 2, 11);
        System.out.println(res);
    }

}