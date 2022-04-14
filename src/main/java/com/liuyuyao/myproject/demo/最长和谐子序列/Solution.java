package com.liuyuyao.myproject.demo.最长和谐子序列;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/13 下午3:48
 * @description：
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int item : nums) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1);
        }
        for (int item : nums) {

            if (hashMap.containsKey(item) && hashMap.containsKey(item + 1)) {
                ans = Math.max(ans, hashMap.get(item) + hashMap.get(item + 1));
            }
        }
        return ans;
    }
}
