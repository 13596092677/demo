package com.liuyuyao.myproject.demo.删除一次得到子数组最大和;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/30 下午6:10
 * @description：
 */
public class Solution {
    public int maximumSum(int[] arr) {
        int[] zero = new int[arr.length];
        int[] once = new int[arr.length];
        int ans = arr[0];
        zero[0] = arr[0];
        once[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            zero[i] = Math.max(arr[i], zero[i-1] + arr[i]);
            once[i] = Math.max(zero[i - 1], once[i - 1] + arr[i]);
            ans = Math.max(ans,Math.max(zero[i], once[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumSum(new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6});
        System.out.println(res);
    }
}
