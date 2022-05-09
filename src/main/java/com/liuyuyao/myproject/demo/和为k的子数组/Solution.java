package com.liuyuyao.myproject.demo.和为k的子数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 下午4:18
 * @description：
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += hashMap.getOrDefault(sum - k, 0);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(res);
    }
}
