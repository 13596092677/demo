package com.liuyuyao.myproject.demo.连续数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : mi
 * create at:  2021/6/8  下午7:18
 * @description: 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int res = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curSum += -1;
            } else{
                curSum += 1;
            }
            if (map.containsKey(curSum)) {
                res = Math.max(res, i - map.get(curSum) + 1);
            } else{
                map.put(curSum, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxLength(new int[]{0, 1});
        System.out.println( res);
    }
}