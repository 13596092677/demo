package com.liuyuyao.myproject.demo.全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 11:31 上午
 * @description：
 */
public class Solution {
    List<Integer> permute = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited);
        return ans;
    }

    void dfs(int[] nums, int[] visited) {
        if (permute.size() == nums.length) {
            ans.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            permute.add(nums[i]);
            visited[i] = 1;
            dfs(nums, visited);
            permute.remove(permute.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{1, 1, 2, 2});
        System.out.println(res);
    }

}
