package com.liuyuyao.myproject.demo.最短无序连续子数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/25 下午10:07
 * @description：
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else{
                max = nums[i];
            }
            if (nums[i] > min) {
                left = i;
            } else{
                min = nums[i];
            }
        }
        return right - left + 1;
    }
}
