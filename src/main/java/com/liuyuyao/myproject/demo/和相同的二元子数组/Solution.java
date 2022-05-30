package com.liuyuyao.myproject.demo.和相同的二元子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/30 下午4:22
 * @description：
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - goal)) {
                ans += hashMap.get(sum - goal);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
