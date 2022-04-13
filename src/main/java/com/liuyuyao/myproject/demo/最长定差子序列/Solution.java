package com.liuyuyao.myproject.demo.最长定差子序列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/12 下午8:06
 * @description：
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item - difference, 0) + 1);
            ans = Math.max(ans, map.get(item));
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
