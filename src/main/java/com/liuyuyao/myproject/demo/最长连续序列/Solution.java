package com.liuyuyao.myproject.demo.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/2 下午3:24
 * @description：
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> hashSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (hashSet.contains(cur + 1)) {
                cur++;
                temp++;
            }
            ans = Math.max(ans,temp);
            temp = 1;
        }
        return ans;
    }
}
