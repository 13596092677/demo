package com.liuyuyao.myproject.demo.分割数组;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/20 下午4:38
 * @description：
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            ++cnt[num];
        }
        int leftMax = nums[0];
        int rightMin = min;
        for (int i = 0; i < nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            --cnt[nums[i]];
            if (cnt[rightMin] == 0) {
                while (cnt[rightMin] == 0) {
                    rightMin++;
                }
            }
            if (leftMax <= rightMin) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12});
        System.out.println(res);
    }
}
