package com.liuyuyao.myproject.demo.最大子序列交替和;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/13 下午6:31
 * @description：
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd = 0;
        long even = nums[0];
        for (int i = 1; i < nums.length; i++) {
            odd = Math.max(odd, even - nums[i]);
            even = Math.max(even, odd + nums[i]);
        }
        return even;
    }
}
