package com.liuyuyao.myproject.demo.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : mi
 * create at:  2021/6/4  下午3:46
 * @description:
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            cntMap.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (cntMap.keySet().contains(target - numbers[i])) {
                if (cntMap.get(target - numbers[i]) != i) {
                    res[0] = i + 1;
                    res[1] = cntMap.get(target - numbers[i]) + 1;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[]{0, 0, 3, 4}, 0);
        System.out.println(res);
    }
}