package com.liuyuyao.myproject.demo.和为s的两个数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/9 下午6:11
 * @description：
 */
public class Solution {
    public List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int base = 0;
        while (base < nums.length) {
            int left = base + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[base] + nums[left] + nums[right] == target) {
                    list.add(nums[base]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(new ArrayList<>(list));
                    list = new ArrayList<>();
                    while (left < right && left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    ++left;
                } else if (nums[base] + nums[left] + nums[right] < target) {
                    while (left < right && left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    ++left;
                } else{
                    while (left < right && right > 0 && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    --right;
                }
            }
            while (base < nums.length - 1 && nums[base] == nums[base + 1]) {
                ++base;
            }
            ++base;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.twoSum(new int[]{-2, 0, 1, 1, 2}, 0);
        System.out.println(res);
    }
}
