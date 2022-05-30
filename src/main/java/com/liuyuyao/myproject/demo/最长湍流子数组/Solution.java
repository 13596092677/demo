package com.liuyuyao.myproject.demo.最长湍流子数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/25 下午8:19
 * @description：
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] up = new int[arr.length];
        int[] down = new int[arr.length];
        up[0] = 1;
        down[0] = 1;
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            up[i] = arr[i] > arr[i - 1] ? down[i - 1] + 1 : 1;
            down[i] = arr[i] < arr[i - 1] ? up[i - 1] + 1 : 1;
            ans = Math.max(ans, Math.max(up[i], down[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        System.out.println(res);
    }
}
