package com.liuyuyao.myproject.demo.和为奇数的子数组数目;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/26 下午8:28
 * @description：
 */
public class Solution {
    public int numOfSubarrays(int[] arr) {
        int[] masks = new int[2];
        int sum = 0;
        double ans = 0;
        masks[0] = 1;
        masks[1] = 0;
        double MOD = Math.pow(10, 9) + 7;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                ans += masks[1];
                ++masks[0];
            } else {
                ans += masks[0];
                ++masks[1];
            }
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numOfSubarrays(new int[]{1, 3, 5});
        System.out.println(res);
    }
}
