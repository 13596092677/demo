package com.liuyuyao.myproject.demo.乘积小于K的子数组;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 下午11:07
 * @description：
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int ans = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0);
        System.out.println(res);
    }
}
