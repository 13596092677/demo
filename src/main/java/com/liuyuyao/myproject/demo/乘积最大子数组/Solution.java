package com.liuyuyao.myproject.demo.乘积最大子数组;

/**
 * @author : mi
 * create at:  2021/6/11  下午2:14
 * @description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] curMaxProduct = new int[nums.length];
        int[]  curMinProduct = new int[nums.length];
        curMaxProduct[0] = nums[0];
        curMinProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMaxProduct[i] = Math.max(curMaxProduct[i - 1] * nums[i], nums[i]);
            curMaxProduct[i] = Math.max(curMaxProduct[i], curMinProduct[i-1] * nums[i]);
            curMinProduct[i] = Math.min(curMinProduct[i - 1] * nums[i], nums[i]);
            curMinProduct[i] = Math.min(curMinProduct[i], curMaxProduct[i-1] * nums[i]);
            res = Math.max(res, curMaxProduct[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(res);

    }
}