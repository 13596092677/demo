package com.liuyuyao.myproject.demo.把数组排成最小的数;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 下午10:43
 * @description：
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(res);
    }
}
