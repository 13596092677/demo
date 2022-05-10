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
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int base = 0;
        while (base < nums.length) {
            int left = base + 1;
            int right = nums.length - 1;
            if (base > 0 && nums[base - 1] == nums[base]) {
                ++base;
                continue;
            }
            while (left < right) {
                if (left > base + 1 && nums[left - 1] == nums[left]) {
                    ++left;
                    continue;
                }
                if (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    --right;
                    continue;
                }
                if (nums[base] + nums[left] + nums[right] == 0) {
                    list.add(nums[base]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(new ArrayList<>(list));
                    list = new ArrayList<>();
                    ++left;
                    --right;
                } else if (nums[base] + nums[left] + nums[right] < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
            ++base;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(res);
    }
}
