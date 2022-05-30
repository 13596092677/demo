package com.liuyuyao.myproject.demo.子数组范围和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/23 下午5:11
 * @description：
 */
public class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
