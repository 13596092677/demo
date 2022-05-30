package com.liuyuyao.myproject.demo.offer_0和1个数相同的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/11 下午8:13
 * @description：
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : nums[i];
            if (hashMap.containsKey(sum)) {
                ans = Math.max(ans, i - hashMap.get(sum) + 1);
            } else {
                hashMap.put(sum, i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxLength(new int[]{1, 0, 1, 0, 0, 1, 0, 1});
        System.out.println(res);
    }
}
