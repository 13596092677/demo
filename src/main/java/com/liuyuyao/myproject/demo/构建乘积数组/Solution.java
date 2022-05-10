package com.liuyuyao.myproject.demo.构建乘积数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 下午10:59
 * @description：
 */
public class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] L = new int[a.length];
        int[] R = new int[a.length];
        int[] ans = new int[a.length];
        L[0] = 1;
        R[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            L[i] = L[i - 1] * a[i - 1];
        }
        for (int i = a.length - 1 - 1; i >= 0; i--) {
            R[i] = R[i + 1] * a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
